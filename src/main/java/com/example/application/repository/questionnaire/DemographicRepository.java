package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, Long> {
}
