package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.NutritionGoalsRepository;
import org.springframework.stereotype.Service;

@Service
public class NutritionGoalsService {

    private NutritionGoalsRepository nutritionGoalsRepository;

    public NutritionGoalsService(NutritionGoalsRepository nutritionGoalsRepository) {
        this.nutritionGoalsRepository = nutritionGoalsRepository;
    }
}
