package com.example.application.model.questionnaire;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "NUTRITION_GOALS")
public class NutritionGoals extends QuestionnaireSection {

    @Column(name = "goal")
    private Goal goal;

    @Column(name = "timeframe_to_achieve")
    private String timeframeToAchieve;

    public enum Goal {
        HEALTH_IMPROVEMENT,
        FAT_LOSS,
        MUSCLE_MASS_INCREASE,
        SPORTS_PERFORMANCE_IMPROVEMENT,
        OTHER
    }
}
