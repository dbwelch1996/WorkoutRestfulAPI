package dev.dbwelch.fitness.workout;

import dev.dbwelch.fitness.Application;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dev.dbwelch.fitness.workout.TypeOfExercise.BARBELL;

@Repository
public class WorkoutRepository {

    private static final Logger log = LoggerFactory.getLogger(WorkoutRepository.class);
    private final JdbcClient jdbcClient;


    public WorkoutRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Workout> findAll(){
        return jdbcClient.sql("select * from workout")
                .query(Workout.class)
                .list();
    }

    public Optional<Workout> findById(Integer id) {
        return jdbcClient.sql("select id, title, startedOn, completedOn, exerciseName, workoutWeight, workoutReps, workoutSets, typeOfExercise FROM Workout WHERE id =:id")
                .param("id", id)
                .query(Workout.class)
                .optional();
    }

    public void create(Workout newWorkout){
        var updated = jdbcClient.sql("INSERT INTO Workout(id, title, startedOn, completedOn, exerciseName, workoutWeight, workoutReps, workoutSets, typeOfExercise) values (?,?,?,?,?,?,?,?,?)")
                .params(List.of(newWorkout.id(), newWorkout.title(),newWorkout.startedOn(),newWorkout.completedOn(),newWorkout.exerciseName(), newWorkout.workoutWeight(), newWorkout.workoutReps(), newWorkout.workoutSets(), newWorkout.typeOfExercise().toString()))
                .update();

            Assert.state(updated == 1, "Failed to create workout" + newWorkout.title());

    }

    public void update (Workout newWorkout, Integer id){
        var updated = jdbcClient.sql("update workout set title = ?, startedOn = ?, completedOn = ?, exerciseName = ?, workoutWeight = ?, workoutReps = ?, workoutSets = ?, typeOfExercise = ? where id = ?")
                .params(List.of(newWorkout.title(),newWorkout.startedOn(),newWorkout.completedOn(),newWorkout.exerciseName(), newWorkout.workoutWeight(), newWorkout.workoutReps(), newWorkout.workoutSets(), newWorkout.typeOfExercise().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update workout" + newWorkout.title());
    }

    //update returns the number of rows that are affected by the update.
    public void delete(Integer id){
        var updated = jdbcClient.sql("DELETE from Workout where id = :id")
                .params("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete workout" + id);
    }

    public int count(){
        return jdbcClient.sql("select * from Workout")
                .query()
                .listOfRows()
                .size();
    }

    public void saveAll(List<Workout> workouts){
        workouts.stream().forEach(this::create);
    }

    public List<Workout> findByTypeOfExercise(String typeOfExercise){
        return jdbcClient.sql("Select from Workout Where typeOfExercise := typeOfExercise")
                .param("typeOfExercise", typeOfExercise)
                .query(Workout.class)
                .list();
    }

}
