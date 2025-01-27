package co.edu.uniminuto.mvc.config.liquibase;

import liquibase.exception.LiquibaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.liquibase.DataSourceClosingSpringLiquibase;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.util.StopWatch;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executor;

import static co.edu.uniminuto.mvc.constants.Constants.*;

/**
 * Specific liquibase.integration.spring.SpringLiquibase that will update the database asynchronously. <p> By default, this asynchronous version only
 * works when using the "dev" profile.<p> The standard liquibase.integration.spring.SpringLiquibase starts Liquibase in the current thread: <ul>
 * <li>This is needed if you want to do some database requests at startup</li> <li>This ensure that the database is ready when the application
 * starts</li> </ul> But as this is a rather slow process, we use this asynchronous version to speed up our start-up time: <ul> <li>On a recent
 * MacBook Pro, start-up time is down from 14 seconds to 8 seconds</li> <li>In production, this can help your application run on platforms like
 * Heroku, where it must start/restart very quickly</li> </ul>
 *
 * @author <a href="mailto:jgarzon@gptech.com.co">Jonathan Garz&oacute;n</a>
 * @version 1.0.0 - 2019-01-27 16:41
 * @since gptech-platform-1.0.0
 */
@Slf4j
@RequiredArgsConstructor
public class AsyncSpringLiquibase extends DataSourceClosingSpringLiquibase {

    private static final String DISABLED_MESSAGE = "Liquibase is disabled";
    private static final String STARTING_ASYNC_MESSAGE = "Starting Liquibase asynchronously, your database might not be ready at startup!";
    private static final String STARTING_SYNC_MESSAGE = "Starting Liquibase synchronously";
    private static final String STARTED_MESSAGE = "Liquibase has updated your database in {} ms";
    private static final String EXCEPTION_MESSAGE = "Liquibase could not start correctly, your database is NOT ready: " + "{}";

    private static final long SLOWNESS_THRESHOLD = 5; // seconds
    private static final String SLOWNESS_MESSAGE = "Warning, Liquibase took more than {} seconds to start up!";

    private final Executor taskExecutor;

    private final Environment env;

    @Override
    @SuppressWarnings({"unused"})
    public void afterPropertiesSet() throws LiquibaseException {
        if (!env.acceptsProfiles(Profiles.of(SPRING_PROFILE_NO_LIQUIBASE))) {
            if (env.acceptsProfiles(Profiles.of(SPRING_PROFILE_DEVELOPMENT, SPRING_PROFILE_HEROKU))) {
                // Prevent Thread Lock with spring-cloud-context GenericScope
                // https://github.com/spring-cloud/spring-cloud-commons/commit/aaa7288bae3bb4d6fdbef1041691223238d77b7b#diff
                // -afa0715eafc2b0154475fe672dab70e4R328
                try (Connection connection = getDataSource().getConnection()) {
                    taskExecutor.execute(() -> {
                        try {
                            log.warn(STARTING_ASYNC_MESSAGE);
                            initDb();
                        } catch (LiquibaseException e) {
                            log.error(EXCEPTION_MESSAGE, e.getMessage(), e);
                        }
                    });
                } catch (SQLException e) {
                    log.error(EXCEPTION_MESSAGE, e.getMessage(), e);
                }
            } else {
                log.debug(STARTING_SYNC_MESSAGE);
                initDb();
            }
        } else {
            log.debug(DISABLED_MESSAGE);
        }
    }

    private void initDb() throws LiquibaseException {
        StopWatch watch = new StopWatch();
        watch.start();
        super.afterPropertiesSet();
        watch.stop();
        log.debug(STARTED_MESSAGE, watch.getTotalTimeMillis());
        if (watch.getTotalTimeMillis() > SLOWNESS_THRESHOLD * 1000L) {
            log.warn(SLOWNESS_MESSAGE, SLOWNESS_THRESHOLD);
        }
    }
}
