package com.example.application.repositories.questionnaire.sections;

import com.example.application.models.questionnaire.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, Long> {
}
