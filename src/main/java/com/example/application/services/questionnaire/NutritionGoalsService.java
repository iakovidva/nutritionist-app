package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.NutritionGoalsRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class NutritionGoalsService {

    private NutritionGoalsRepository nutritionGoalsRepository;

    public NutritionGoalsService(NutritionGoalsRepository nutritionGoalsRepository) {
        this.nutritionGoalsRepository = nutritionGoalsRepository;
    }
}
