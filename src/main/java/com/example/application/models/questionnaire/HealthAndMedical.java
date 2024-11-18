package com.example.application.models.questionnaire;

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
@Entity(name = "HEALTH_MEDICAL")
public class HealthAndMedical extends QuestionnaireSection {

    @Column(name = "health_condition")
    private String healthCondition;

    @Column(name = "dietary_supplements")
    private String dietarySupplements;

    @Column(name = "lack_of_vitamins_or_minerals")
    private String lackOfVitaminsOrMinerals;

}
