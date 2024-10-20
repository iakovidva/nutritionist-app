package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.DietaryPreferencesRepository;
import org.springframework.stereotype.Service;

@Service
public class DietaryPreferencesService {

    private DietaryPreferencesRepository dietaryPreferencesRepository;

    public DietaryPreferencesService(DietaryPreferencesRepository dietaryPreferencesRepository) {
        this.dietaryPreferencesRepository = dietaryPreferencesRepository;
    }
}
