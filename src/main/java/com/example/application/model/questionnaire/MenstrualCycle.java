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
@Entity(name = "MENSTRUAL_CYCLE")
public class MenstrualCycle extends QuestionnaireSection {

    @Column(name = "regular_menstrual_cycle", nullable = false)
    private Boolean regularMenstrualCycle;

    @Column(name = "irregular_cycle_reason")
    private String irregularCycleReason;

    @Column(name = "changes_in_appetite_or_weight", nullable = false)
    private Boolean changesInAppetiteOrWeight;

    @Column(name = "description_of_changes")
    private String descriptionOfChanges;

    @Column(name = "day_of_cycle_when_weighed")
    private int dayOfCycleWhenWeighed;

}
