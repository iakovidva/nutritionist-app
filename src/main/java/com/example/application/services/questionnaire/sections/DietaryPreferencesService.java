package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.DietaryPreferences;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.DietaryPreferencesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DietaryPreferencesService {

    private static final Logger log = LoggerFactory.getLogger(DietaryPreferencesService.class);

    private DietaryPreferencesRepository dietaryPreferencesRepository;

    public DietaryPreferencesService(DietaryPreferencesRepository dietaryPreferencesRepository) {
        this.dietaryPreferencesRepository = dietaryPreferencesRepository;
    }

    public void saveInfo(DietaryPreferences dietaryPreferences, Questionnaire questionnaire) {
        dietaryPreferences.setQuestionnaire(questionnaire);
        dietaryPreferencesRepository.save(dietaryPreferences);
        log.info("Saving {}", dietaryPreferences);
    }
}
