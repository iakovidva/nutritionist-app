package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Long> {
}
