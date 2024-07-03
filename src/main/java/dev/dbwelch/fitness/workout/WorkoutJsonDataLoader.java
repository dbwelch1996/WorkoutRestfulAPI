package dev.dbwelch.fitness.workout;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class WorkoutJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(WorkoutJsonDataLoader.class);
    private final WorkoutRepository workoutRepository;
    private final ObjectMapper objectMapper;

    public WorkoutJsonDataLoader(WorkoutRepository workoutRepository, ObjectMapper objectMapper){
        this.workoutRepository = workoutRepository;
        this.objectMapper = objectMapper;
    }

    //Reading data from json data and populating the data base
    @Override
    public void run(String... args) throws Exception{
        if (workoutRepository.count() == 0){
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/fitnessz.json")){
                Workouts allWorkouts = objectMapper.readValue(inputStream, Workouts.class);
                log.info("Reading {} runs from JSON data", allWorkouts.workouts().size());
                workoutRepository.saveAll(allWorkouts.workouts());
            }catch (IOException e){
                throw new RuntimeException("Failed to read json data");
            }
        } else {
            log.info("Not loading Workouts from JSON data because the collection contains data");
        }
    }
}
