package com.example.application.models.questionnaire;

import com.example.application.enums.Goals;
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
    @Column(name = "goal", nullable = false)
    private Goals goals;

    @Column(name = "timeframe_to_achieve")
    private String timeframeToAchieve;
}
