package com.example.application.repositories.questionnaire.sections;

import com.example.application.models.questionnaire.HealthAndMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthAndMedicalRepository extends JpaRepository<HealthAndMedical, Long> {
}
