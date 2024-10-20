package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.HealthAndMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthAndMedicalRepository extends JpaRepository<HealthAndMedical, Long> {
}
