package dev.dbwelch.fitness;

import dev.dbwelch.fitness.workout.Workout;
import dev.dbwelch.fitness.workout.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static dev.dbwelch.fitness.workout.TypeOfExercise.BARBELL;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	/*
	@Bean
	CommandLineRunner runner(WorkoutRepository workoutRepository){
	return args -> {
		Workout workout = new Workout(1, "First Workout", LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Push-ups", 0, 15, 3, BARBELL);
		workoutRepository.create(workout);
	};
	}

	 */
}
