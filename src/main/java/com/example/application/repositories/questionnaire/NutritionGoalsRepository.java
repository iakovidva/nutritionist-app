package com.example.application.repositories.questionnaire;

import com.example.application.models.questionnaire.NutritionGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionGoalsRepository extends JpaRepository<NutritionGoals, Long> {
}
