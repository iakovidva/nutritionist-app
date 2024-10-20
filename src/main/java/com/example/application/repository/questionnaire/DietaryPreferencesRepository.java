package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.DietaryPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaryPreferencesRepository extends JpaRepository<DietaryPreferences, Long> {
}
