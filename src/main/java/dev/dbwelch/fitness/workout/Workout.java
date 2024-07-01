package dev.dbwelch.fitness.workout;

import java.time.LocalDateTime;

public record Workout(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        String exerciseName,
        Integer workoutWeight,
        Integer workoutReps,
        Integer workoutSets,
        TypeOfExercise typeOfExercise
) {}
