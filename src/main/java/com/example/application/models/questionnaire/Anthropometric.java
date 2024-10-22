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
@Entity(name = "ANTHROPOMETRIC")
public class Anthropometric extends QuestionnaireSection {

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "weight", nullable = false)
    private float weight;

    @Column(name = "waist_circumference")
    private int waistCircumference; //at the narrowest point for women - at the navel for men

    @Column(name = "recent_measures")
    private String recentMeasures;
}
