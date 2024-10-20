package com.example.application.model.questionnaire;

import com.example.application.model.common.WeeklyFrequency;
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
@Entity(name = "PHYSICAL_ACTIVITY")
public class PhysicalActivity extends QuestionnaireSection {

    @Column(name = "exercise_frequency", nullable = false)
    private WeeklyFrequency exerciseFrequency;

    @Column(name = "usual_training_time")
    private String usualTrainingTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "endurance_frequency")
    private WeeklyFrequency enduranceFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "strength_training_frequency")
    private WeeklyFrequency strengthTrainingFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "yoga_pilates_frequency")
    private WeeklyFrequency yogaPilatesFrequency;

    @Column(name = "other_activity")
    private String otherActivity;

    @Enumerated(EnumType.STRING)
    @Column(name = "other_activity_frequency")
    private WeeklyFrequency otherActivityFrequency;
}
