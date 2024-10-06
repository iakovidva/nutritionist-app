package com.example.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name = "Workout")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("duration_minutes")
    private String durationMinutes;

    @JsonProperty("calories_burned")
    private String caloriesBurned;

    @JsonProperty("workout_date")
    private String workoutDate;

    @JsonProperty("created_at")
    @CreatedDate
    private String createdAt;

    @JsonProperty("updated_at")
    @LastModifiedDate
    private String updatedAt;
}
