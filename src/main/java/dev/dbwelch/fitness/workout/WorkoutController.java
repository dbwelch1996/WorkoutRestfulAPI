package dev.dbwelch.fitness.workout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/api/workouts")
    List<Workout> findAll(){
        return workoutRepository.findAll();
    }
}
