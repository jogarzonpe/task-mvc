package co.edu.uniminuto.mvc.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    /**
     * Spring profile for development
     */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    /**
     * Spring profile used when deploying to Heroku
     */
    public static final String SPRING_PROFILE_HEROKU = "heroku";

    /**
     * Spring profile used to disable running liquibase
     */
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";


}
