package com.example.application.model.questionnaire;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "goal")
    private Goal goal;

    @Column(name = "timeframe_to_achieve")
    private String timeframeToAchieve;

    public enum Goal {
        HEALTH_IMPROVEMENT,
        FAT_LOSS,
        WEIGHT_LOSS,
        GAIN_WEIGHT,
        MUSCLE_MASS_INCREASE,
        SPORTS_PERFORMANCE_IMPROVEMENT,
        OTHER
    }

}
