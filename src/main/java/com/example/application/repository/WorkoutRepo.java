package com.example.application.repository;

import com.example.application.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {
}
