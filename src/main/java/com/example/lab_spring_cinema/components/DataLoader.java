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
        movieService.addNewMovie("Interstellar", "12A", 181);
        movieService.addNewMovie("Alien: Covenant", "18", 117);
        movieService.addNewMovie("Iron Man", "12A", 126);
        movieService.addNewMovie("Ant-Man", "PG-13", 117);
        movieService.addNewMovie("Titanic", "18", 160);
        movieService.addNewMovie("Avengers: Engdame", "12A", 181);

    }

}
