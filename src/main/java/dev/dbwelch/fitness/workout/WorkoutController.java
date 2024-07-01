package dev.dbwelch.fitness.workout;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    //Singleton design pattern
    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    //Prints all records
    @GetMapping("")
    List<Workout> findAll(){
        return workoutRepository.findAll();
    }

    //Read
    //Gets the ID of the workout
    @GetMapping("{id}")
    Workout findById(@PathVariable Integer id){
        Optional<Workout> workout = workoutRepository.findByID(id);
        if (workout.isEmpty()){
            throw new WorkoutNotFoundException();
        }
        return workout.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Workout workout){
        workoutRepository.createWorkout(workout);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Workout workout, @PathVariable Integer id){
        workoutRepository.updateWorkout(workout,id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        workoutRepository.deleteWorkout(id);
    }

}
