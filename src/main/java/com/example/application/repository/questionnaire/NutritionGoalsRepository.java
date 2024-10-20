package com.example.application.repository.questionnaire;

import com.example.application.model.questionnaire.NutritionGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionGoalsRepository extends JpaRepository<NutritionGoals, Long> {
}
