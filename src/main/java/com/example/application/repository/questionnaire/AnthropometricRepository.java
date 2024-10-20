package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.Anthropometric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnthropometricRepository extends JpaRepository<Anthropometric, Long> {
}
