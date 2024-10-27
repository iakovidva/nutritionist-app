package com.example.application.services.questionnaire.sections;

import com.example.application.dto.QuestionnaireData;
import com.example.application.models.questionnaire.Anthropometric;
import com.example.application.models.questionnaire.Demographic;
import com.example.application.models.questionnaire.DietaryPreferences;
import com.example.application.models.questionnaire.HealthAndMedical;
import com.example.application.models.questionnaire.MenstrualCycle;
import com.example.application.models.questionnaire.NutritionGoals;
import com.example.application.models.questionnaire.PhysicalActivity;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.models.questionnaire.WorkAndMealSchedule;
import com.example.application.services.questionnaire.QuestionnaireService;
import org.springframework.stereotype.Service;

@Service
public class SectionsService {

    private AnthropometricService anthropometricService;
    private DemographicService demographicService;
    private DietaryPreferencesService dietaryPreferencesService;
    private HealthAndMedicalService healthAndMedicalService;
    private MenstrualCycleService menstrualCycleService;
    private NutritionGoalsService nutritionGoalsService;
    private PhysicalActivityService physicalActivityService;
    private WorkAndMealScheduleService workAndMealScheduleService;

    public SectionsService(QuestionnaireService questionnaireService,
                           AnthropometricService anthropometricService,
                           DemographicService demographicService,
                           DietaryPreferencesService dietaryPreferencesService,
                           HealthAndMedicalService healthAndMedicalService,
                           MenstrualCycleService menstrualCycleService,
                           NutritionGoalsService nutritionGoalsService,
                           PhysicalActivityService physicalActivityService,
                           WorkAndMealScheduleService workAndMealScheduleService) {
        this.anthropometricService = anthropometricService;
        this.demographicService = demographicService;
        this.dietaryPreferencesService = dietaryPreferencesService;
        this.healthAndMedicalService = healthAndMedicalService;
        this.menstrualCycleService = menstrualCycleService;
        this.nutritionGoalsService = nutritionGoalsService;
        this.physicalActivityService = physicalActivityService;
        this.workAndMealScheduleService = workAndMealScheduleService;
    }

    public void findAndSaveQuestionnaireSections(Questionnaire questionnaire, QuestionnaireData questionnaireData) {
        Anthropometric anthropometric = questionnaireData.getAnthropometric();
        Demographic demographic = questionnaireData.getDemographic();
        DietaryPreferences dietaryPreferences = questionnaireData.getDietaryPreferences();
        HealthAndMedical healthAndMedical = questionnaireData.getHealthAndMedical();
        MenstrualCycle menstrualCycle = questionnaireData.getMenstrualCycle();
        NutritionGoals nutritionGoals = questionnaireData.getNutritionGoals();
        PhysicalActivity physicalActivity = questionnaireData.getPhysicalActivity();
        WorkAndMealSchedule workAndMealSchedule = questionnaireData.getWorkAndMealSchedule();

        saveQuestionnaireSections(questionnaire, anthropometric, demographic, dietaryPreferences, healthAndMedical, menstrualCycle,
                nutritionGoals, physicalActivity, workAndMealSchedule);
    }

    private void saveQuestionnaireSections(Questionnaire questionnaire,
                                           Anthropometric anthropometric,
                                           Demographic demographic,
                                           DietaryPreferences dietaryPreferences,
                                           HealthAndMedical healthAndMedical,
                                           MenstrualCycle menstrualCycle,
                                           NutritionGoals nutritionGoals,
                                           PhysicalActivity physicalActivity,
                                           WorkAndMealSchedule workAndMealSchedule) {
        anthropometricService.saveInfo(anthropometric, questionnaire);
        demographicService.saveInfo(demographic, questionnaire);
        dietaryPreferencesService.saveInfo(dietaryPreferences, questionnaire);
        healthAndMedicalService.saveInfo(healthAndMedical, questionnaire);
        menstrualCycleService.saveInfo(menstrualCycle, questionnaire);
        nutritionGoalsService.saveInfo(nutritionGoals, questionnaire);
        physicalActivityService.saveInfo(physicalActivity, questionnaire);
        workAndMealScheduleService.saveInfo(workAndMealSchedule, questionnaire);
    }

}
