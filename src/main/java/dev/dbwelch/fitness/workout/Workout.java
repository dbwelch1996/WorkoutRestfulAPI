package dev.dbwelch.fitness.workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Workout(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        String exerciseName,
        @Positive
        Integer workoutWeight,
        @Positive
        Integer workoutReps,
        @Positive
        Integer workoutSets,
        TypeOfExercise typeOfExercise
) {}
