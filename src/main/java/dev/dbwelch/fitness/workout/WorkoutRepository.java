package dev.dbwelch.fitness.workout;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dev.dbwelch.fitness.workout.TypeOfExercise.BARBELL;

@Repository
public class WorkoutRepository {

    private List<Workout> workouts = new ArrayList<Workout>();

    List<Workout> findAll(){
        return workouts;
    }
    Optional<Workout> findByID(Integer id){
        return workouts.stream().
                filter(workout-> workout.id() == id).
                findFirst();
    }
    void createWorkout(Workout workout){
        workouts.add(workout);
    }

    void updateWorkout(Workout workout, Integer id){
        Optional<Workout> existingWorkout = findByID(id);
        if (existingWorkout.isPresent()){
            workouts.set(workouts.indexOf(existingWorkout.get()), workout);
        }
    }

    void deleteWorkout(Integer id){
        workouts.removeIf(workout -> workout.id().equals(id));
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
