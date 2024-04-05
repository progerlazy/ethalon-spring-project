package com.progerlazy.ethalonspring.docker;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Testcontainers
public interface WithDatabaseInitializer extends ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * Init config for test container
     */
    @Container
    PostgreSQLContainer<?> POSTGRES_APP_CONTAINER = new PostgreSQLContainer<>("postgres:15.3")
            .withDatabaseName("ehtalon_db")
            .withUsername("sa")
            .withPassword("sa")
            .waitingFor(new LogMessageWaitStrategy()
                    .withRegEx(".*database system is ready to accept connections.*")
                    .withTimes(1)
                    .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS))
            );


    @Override
    default void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(
                "POSTGRES_URL=" + POSTGRES_APP_CONTAINER.getJdbcUrl(),
                "POSTGRES_USER_NAME=" + POSTGRES_APP_CONTAINER.getUsername(),
                "POSTGRES_PASSWORD=" + POSTGRES_APP_CONTAINER.getPassword()
        ).applyTo(applicationContext.getEnvironment());
    }
}
