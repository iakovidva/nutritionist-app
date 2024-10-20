package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.DietaryPreferencesRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class DietaryPreferencesService {

    private DietaryPreferencesRepository dietaryPreferencesRepository;

    public DietaryPreferencesService(DietaryPreferencesRepository dietaryPreferencesRepository) {
        this.dietaryPreferencesRepository = dietaryPreferencesRepository;
    }
}
