package com.example.application.repositories.questionnaire.sections;

import com.example.application.models.questionnaire.WorkAndMealSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAndMealScheduleRepository extends JpaRepository<WorkAndMealSchedule, Long> {
}
