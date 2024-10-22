package com.example.application.repositories.questionnaire;

import com.example.application.models.questionnaire.MenstrualCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenstrualCycleRepository extends JpaRepository<MenstrualCycle, Long> {
}
