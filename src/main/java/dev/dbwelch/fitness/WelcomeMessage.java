package dev.dbwelch.fitness;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String printWelcomeMessage(){
        return "Welcome to my first spring boot application";
    }
}
