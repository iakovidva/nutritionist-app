package com.example.application.services;

import com.example.application.model.Workout;
import com.example.application.repository.WorkoutRepo;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@BrowserCallable
@AnonymousAllowed
@Service
public class WorkoutService {

    @Autowired
    WorkoutRepo repo;

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
