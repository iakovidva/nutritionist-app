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
@Entity(name = "HEALTH_MEDICAL_HISTORY")
public class HealthAndMedicalHistory extends QuestionnaireSection {

    @Column(name = "health_condition")
    private String healthCondition;

    @Column(name = "lack_of_vitamins_or_minerals")
    private String lackOfVitaminsOrMinerals;

    @Column(name = "dietary_supplements")
    private String dietarySupplements;
}
