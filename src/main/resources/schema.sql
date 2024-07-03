CREATE TABLE IF NOT EXISTS Workout (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    startedOn TIMESTAMP,
    completedOn TIMESTAMP,
    exerciseName VARCHAR(255),
    workoutWeight INT NOT NULL,
    workoutReps INT NOT NULL,
    workoutSets INT NOT NULL,
    typeOfExercise VARCHAR(50) NOT NULL
);