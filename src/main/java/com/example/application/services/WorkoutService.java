package com.example.application.services;

import com.example.application.models.Workout;
import com.example.application.repositories.WorkoutRepo;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired private WorkoutRepo repo;

    private Random rand = new Random();

    public List<Workout> getWorks() {
        System.out.println(repo.findAll());
        return repo.findAll();
    }

    public Workout createWorkout() {
        Workout workout = new Workout();
        workout.setName(String.valueOf(rand.nextInt(10, 500)));
        workout.setType(String.valueOf(rand.nextInt(10, 500)));
        workout.setCaloriesBurned(String.valueOf(rand.nextInt(10, 500)));
        workout.setDurationMinutes(String.valueOf(rand.nextInt(2, 50)));
        workout.setWorkoutDate(LocalDate.now().toString());
        workout.setCreatedAt(LocalDate.now().toString());
        workout.setUpdatedAt(LocalDate.now().toString());
        return repo.save(workout);
    }
}
