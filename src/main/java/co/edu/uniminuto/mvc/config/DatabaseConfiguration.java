package co.edu.uniminuto.mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for Data Base.
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@EntityScan("co.edu.uniminuto.mvc.data.model")
@EnableJpaRepositories(value = "co.edu.uniminuto.mvc.data.repository")
public class DatabaseConfiguration {
}
