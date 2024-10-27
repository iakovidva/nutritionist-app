package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.HealthAndMedical;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.HealthAndMedicalRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthAndMedicalService {

    private HealthAndMedicalRepository healthAndMedicalRepository;

    public HealthAndMedicalService(HealthAndMedicalRepository healthAndMedicalRepository) {
        this.healthAndMedicalRepository = healthAndMedicalRepository;
    }

    public void saveInfo(HealthAndMedical healthAndMedical, Questionnaire questionnaire) {
        healthAndMedical.setQuestionnaire(questionnaire);
        healthAndMedicalRepository.save(healthAndMedical);
        System.out.println("Saving + " + healthAndMedical);
    }
}