package com.example.application.model.questionnaire;

import com.example.application.model.User;
import com.example.application.model.common.WeeklyFrequency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(nullable = false)
    private DietType dietType;

    @Column(name = "avoided_foods")
    private String avoidedFoods;

    @Column(name = "drinks_alcohol")
    private Boolean drinksAlcohol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeeklyFrequency alcoholFrequency;

    @Column(name = "has_allergy_or_intolerance", nullable = false)
    private Boolean hasAllergyOrIntolerance;

    @Column(name = "allergies_or_intolerances")
    private String alergiesOrIntolerances;

    public enum DietType {
        BALANCED_DIET,
        VEGETARIAN,
        VEGAN,
        PALEO,
        KETOGENIC,
        GLUTEN_FREE,
        OTHER
    }
}
