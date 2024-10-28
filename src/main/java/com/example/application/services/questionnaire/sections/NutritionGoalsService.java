package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.NutritionGoals;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.NutritionGoalsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NutritionGoalsService {

    private static final Logger log = LoggerFactory.getLogger(NutritionGoalsService.class);

    private NutritionGoalsRepository nutritionGoalsRepository;

    public NutritionGoalsService(NutritionGoalsRepository nutritionGoalsRepository) {
        this.nutritionGoalsRepository = nutritionGoalsRepository;
    }

    public void saveInfo(NutritionGoals nutritionGoals, Questionnaire questionnaire) {
        nutritionGoals.setQuestionnaire(questionnaire);
        nutritionGoalsRepository.save(nutritionGoals);
        log.info("Saving {}", nutritionGoals);
    }
}
