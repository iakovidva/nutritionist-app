package com.example.application.dto;

import com.example.application.models.questionnaire.Anthropometric;
import com.example.application.models.questionnaire.Demographic;
import com.example.application.models.questionnaire.DietaryPreferences;
import com.example.application.models.questionnaire.HealthAndMedical;
import com.example.application.models.questionnaire.MenstrualCycle;
import com.example.application.models.questionnaire.NutritionGoals;
import com.example.application.models.questionnaire.PhysicalActivity;
import com.example.application.models.questionnaire.WorkAndMealSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireData {
    private Anthropometric anthropometric;
    private Demographic demographic;
    private DietaryPreferences dietaryPreferences;
    private HealthAndMedical healthAndMedical;
    private MenstrualCycle menstrualCycle;
    private NutritionGoals nutritionGoals;
    private PhysicalActivity physicalActivity;
    private WorkAndMealSchedule workAndMealSchedule;
}
