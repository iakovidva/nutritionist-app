package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.MenstrualCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenstrualCycleRepository extends JpaRepository<MenstrualCycle, Long> {
}
