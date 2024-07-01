package dev.dbwelch.fitness.workout;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//returns 404
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkoutNotFoundException extends RuntimeException{
    public  WorkoutNotFoundException(){
        super("Workout Not Found");
    }
}
