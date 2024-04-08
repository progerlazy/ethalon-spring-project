package com.progerlazy.ethalonspring.service;

import com.progerlazy.ethalonspring.dto.DummyData;

import java.util.List;

public interface DummyService {
    List<DummyData> getAllDummyDataFromDb();
}
