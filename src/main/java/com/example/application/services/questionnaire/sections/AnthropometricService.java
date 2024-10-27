package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.Anthropometric;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.AnthropometricRepository;
import org.springframework.stereotype.Service;

@Service
public class AnthropometricService {

    private AnthropometricRepository anthropometricRepository;

    public AnthropometricService(AnthropometricRepository anthropometricRepository) {
        this.anthropometricRepository = anthropometricRepository;
    }

    public void saveInfo(Anthropometric anthropometric, Questionnaire questionnaire) {
        anthropometric.setQuestionnaire(questionnaire);
        anthropometricRepository.save(anthropometric);
        System.out.println("Saving + " + anthropometric);
    }
}
