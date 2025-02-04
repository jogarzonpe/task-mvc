package co.edu.uniminuto.mvc.test;

import co.edu.uniminuto.mvc.InitApp;
import co.edu.uniminuto.mvc.config.AsyncConfiguration;
import co.edu.uniminuto.mvc.config.DatabaseConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
    classes = {InitApp.class, AsyncConfiguration.class, DatabaseConfiguration.class}
)
public @interface IntegrationTest {
}
