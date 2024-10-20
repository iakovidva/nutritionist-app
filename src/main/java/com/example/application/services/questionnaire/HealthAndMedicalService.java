package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.HealthAndMedicalRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class HealthAndMedicalService {

    private HealthAndMedicalRepository healthAndMedicalRepository;

    public HealthAndMedicalService(HealthAndMedicalRepository healthAndMedicalRepository) {
        this.healthAndMedicalRepository = healthAndMedicalRepository;
    }
}
