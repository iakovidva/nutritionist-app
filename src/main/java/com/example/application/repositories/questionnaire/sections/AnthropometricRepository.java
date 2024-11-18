package com.example.application.repositories.questionnaire.sections;

import com.example.application.models.questionnaire.Anthropometric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnthropometricRepository extends JpaRepository<Anthropometric, Long> {
}
