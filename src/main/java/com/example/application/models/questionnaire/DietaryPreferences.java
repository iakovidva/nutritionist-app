package com.example.application.models.questionnaire;

import com.example.application.enums.DietType;
import com.example.application.enums.WeeklyFrequency;
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
@Entity(name = "DIETARY_PREFERENCES")
public class DietaryPreferences extends QuestionnaireSection {

    @Enumerated(EnumType.STRING)
    @Column(name = "diet_type", nullable = false)
    private DietType dietType;

    @Column(name = "avoided_foods")
    private String avoidedFoods;

    @Column(name = "has_allergy_or_intolerance", nullable = false)
    private Boolean hasAllergyOrIntolerance;

    @Column(name = "allergies_or_intolerances")
    private String alergiesOrIntolerances;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeeklyFrequency alcoholFrequency;
}
