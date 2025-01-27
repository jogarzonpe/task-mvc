package co.edu.uniminuto.mvc.config;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Web configurer to register logs when application is starting.
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebConfigurer implements ServletContextInitializer {

    /**
     * Environment configuration instance.
     */
    private final Environment env;

    /**
     * Method to execute action when servlets are starting.
     *
     * @param servletContext the {@code ServletContext} to initialize
     */
    @Override
    public void onStartup(ServletContext servletContext) {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }
        log.info("Web application fully configured");
    }

}
