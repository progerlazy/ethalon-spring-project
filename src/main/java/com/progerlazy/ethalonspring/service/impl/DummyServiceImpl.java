package com.progerlazy.ethalonspring.service.impl;

import com.progerlazy.ethalonspring.dto.DummyData;
import com.progerlazy.ethalonspring.service.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DummyServiceImpl implements DummyService {

    @Override
    public List<DummyData> getAllDummyDataFromDb() {
        return List.of();
    }
}
