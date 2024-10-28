package com.example.application.services;

import com.example.application.models.Workout;
import com.example.application.repositories.WorkoutRepo;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private static final Logger log = LoggerFactory.getLogger(WorkoutService.class);

    @Autowired
    private WorkoutRepo repo;

    private final Random rand = new Random();

    public List<Workout> getWorks() {
        log.info(repo.findAll().toString());
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
