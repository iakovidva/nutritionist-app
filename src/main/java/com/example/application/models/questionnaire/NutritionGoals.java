package com.example.application.models.questionnaire;

import com.example.application.enums.Goals;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;
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

    @ElementCollection(targetClass = Goals.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "nutrition_goal", joinColumns = @JoinColumn(name = "nutrition_goals_id"))
    @Column(name = "goal", nullable = false)
    private Set<Goals> goals = new HashSet<>();

    @Column(name = "timeframe_to_achieve")
    private String timeframeToAchieve;
}
