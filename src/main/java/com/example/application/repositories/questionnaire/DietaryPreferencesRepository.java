package com.example.application.repositories.questionnaire;

import com.example.application.models.questionnaire.DietaryPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaryPreferencesRepository extends JpaRepository<DietaryPreferences, Long> {
}
