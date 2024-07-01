CREATE TABLE IF NOT EXISTS Workout{
    id INT NOT NULL,
    title varchar(250) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    exercise_name varchar(250) NOT NULL,
    workout_weight INT NOT NULL,
    workout_reps INT NOT NULL,
    workout_sets INT NOT NULL,
    type_of_exercise varchar (10) NOT NULL,
    PRIMARY KEY (id)





    }