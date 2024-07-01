package dev.dbwelch.fitness.workout;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static dev.dbwelch.fitness.workout.TypeOfExercise.BARBELL;

@Repository
public class WorkoutRepository {

    private List<Workout> workouts = new ArrayList<Workout>();

    List<Workout> findAll(){
        return workouts;
    }

    @PostConstruct
    private void init(){
        workouts.add(new Workout(1, "push",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                "Bench Press",
                225,
                8,
                3,
                BARBELL ));

        workouts.add(new Workout(2, "pull",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                "Row",
                185,
                12,
                3,
                BARBELL ));
    }
}
