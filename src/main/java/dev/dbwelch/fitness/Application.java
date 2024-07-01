package dev.dbwelch.fitness;

import dev.dbwelch.fitness.workout.Workout;
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
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Workout workout = new Workout(1, "push", LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Bench Press", 225, 8, 3, BARBELL );
			log.info("Workout" + workout);
		};

	}

}
