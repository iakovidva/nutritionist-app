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
@Entity(name = "WORK_MEAL_SCHEDULE")
public class WorkAndMealSchedule extends QuestionnaireSection {

    @Column(name = "working_hours")
    private String workingHours;

    @Column(name = "meals_daily")
    private int mealsDaily;

    @Column(name = "meal_times")
    private String mealTimes;

}
