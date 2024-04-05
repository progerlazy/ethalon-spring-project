package com.progerlazy.ethalonspring.integration.controller;

import com.progerlazy.ethalonspring.docker.WithDatabaseInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = DummyControllerTests.class)
public class DummyControllerTests implements WithDatabaseInitializer {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void dummyGetMethodTest() throws Exception {
        mockMvc.perform(get("/dummy/"))
                .andExpect(status().isOk());
    }

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        WithDatabaseInitializer.super.initialize(context);
    }
}
