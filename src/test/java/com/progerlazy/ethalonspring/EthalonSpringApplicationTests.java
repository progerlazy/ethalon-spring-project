package com.progerlazy.ethalonspring;

import com.progerlazy.ethalonspring.docker.WithDatabaseInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = EthalonSpringApplicationTests.class)
class EthalonSpringApplicationTests implements WithDatabaseInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        WithDatabaseInitializer.super.initialize(context);
    }

    @Test
    void contextLoads() {
    }

}
