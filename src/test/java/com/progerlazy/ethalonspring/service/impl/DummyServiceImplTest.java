package com.progerlazy.ethalonspring.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DummyServiceImplTest {

    @Mock
    DummyServiceImpl dummyService;

    @Test
    @DisplayName("Dummy test description")
    void getAllDummyDataFromDb() {
        when(dummyService.getAllDummyDataFromDb()).thenReturn(new ArrayList<>());
        var result = dummyService.getAllDummyDataFromDb();

        assertThat(result).isNotNull();
    }
}