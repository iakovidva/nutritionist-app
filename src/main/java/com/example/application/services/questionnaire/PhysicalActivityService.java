package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.PhysicalActivityRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class PhysicalActivityService {

    private PhysicalActivityRepository physicalActivityRepository;

    public PhysicalActivityService(PhysicalActivityRepository physicalActivityRepository) {
        this.physicalActivityRepository = physicalActivityRepository;
    }
}
