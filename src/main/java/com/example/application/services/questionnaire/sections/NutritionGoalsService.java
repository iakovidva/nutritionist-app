package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.NutritionGoals;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.NutritionGoalsRepository;
import org.springframework.stereotype.Service;

@Service
public class NutritionGoalsService {

    private NutritionGoalsRepository nutritionGoalsRepository;

    public NutritionGoalsService(NutritionGoalsRepository nutritionGoalsRepository) {
        this.nutritionGoalsRepository = nutritionGoalsRepository;
    }

    public void saveInfo(NutritionGoals nutritionGoals) {
        System.out.println("Saving + " + nutritionGoals);
    }

    public void saveInfo(NutritionGoals nutritionGoals, Questionnaire questionnaire) {
        nutritionGoals.setQuestionnaire(questionnaire);
        nutritionGoalsRepository.save(nutritionGoals);
        System.out.println("Saving + " + nutritionGoals);
    }
}
