package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.Anthropometric;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.AnthropometricRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnthropometricService {

    private static final Logger log = LoggerFactory.getLogger(AnthropometricService.class);

    private AnthropometricRepository anthropometricRepository;

    public AnthropometricService(AnthropometricRepository anthropometricRepository) {
        this.anthropometricRepository = anthropometricRepository;
    }

    public void saveInfo(Anthropometric anthropometric, Questionnaire questionnaire) {
        anthropometric.setQuestionnaire(questionnaire);
        anthropometricRepository.save(anthropometric);
        log.info("Saving {}", anthropometric);
    }
}
