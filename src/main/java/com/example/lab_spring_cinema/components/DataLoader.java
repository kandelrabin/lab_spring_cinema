package com.example.lab_spring_cinema.components;

import com.example.lab_spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        movieService.addNewMovie("Interstellar", "12A", 2.8);
        movieService.addNewMovie("Alien: Covenant", "15", 2.0);
        movieService.addNewMovie("Iron Man", "12A", 2.0);
        movieService.addNewMovie("Ant-Man and the Wasp: Quantumania", "PG-13", 2.0);
    }

}
