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
@Entity(name = "WORK_MEAL_SCHEDULE")
public class WorkAndMealSchedule extends QuestionnaireSection {

    @Column(name = "meals_daily")
    private Integer mealsDaily;

    @Column(name = "meal_times")
    private String mealTimes;

    @Column(name = "working_hours")
    private String workingHours;

}
