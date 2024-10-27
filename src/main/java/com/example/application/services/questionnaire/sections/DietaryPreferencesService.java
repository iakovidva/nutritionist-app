package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.DietaryPreferences;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.DietaryPreferencesRepository;
import org.springframework.stereotype.Service;

@Service
public class DietaryPreferencesService {

    private DietaryPreferencesRepository dietaryPreferencesRepository;

    public DietaryPreferencesService(DietaryPreferencesRepository dietaryPreferencesRepository) {
        this.dietaryPreferencesRepository = dietaryPreferencesRepository;
    }

    public void saveInfo(DietaryPreferences dietaryPreferences, Questionnaire questionnaire) {
        dietaryPreferences.setQuestionnaire(questionnaire);
        dietaryPreferencesRepository.save(dietaryPreferences);
        System.out.println("Saving + " + dietaryPreferences);
    }
}
