package com.example.application.services.questionnaire;

import com.example.application.repositories.questionnaire.HealthAndMedicalRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthAndMedicalService {

    private HealthAndMedicalRepository healthAndMedicalRepository;

    public HealthAndMedicalService(HealthAndMedicalRepository healthAndMedicalRepository) {
        this.healthAndMedicalRepository = healthAndMedicalRepository;
    }
}
