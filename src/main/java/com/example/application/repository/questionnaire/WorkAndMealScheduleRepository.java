package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.WorkAndMealSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAndMealScheduleRepository extends JpaRepository<WorkAndMealSchedule, Long> {
}
