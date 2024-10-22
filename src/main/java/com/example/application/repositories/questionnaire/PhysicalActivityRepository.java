package com.example.application.repositories.questionnaire;

import com.example.application.models.questionnaire.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Long> {
}
