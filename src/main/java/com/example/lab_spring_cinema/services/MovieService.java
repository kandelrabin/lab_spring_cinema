package com.example.lab_spring_cinema.services;

import com.example.lab_spring_cinema.models.Movie;
import com.example.lab_spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addNewMovie(String title, String rating, double duration){
        Movie movie = new Movie(title, rating, duration);
        movieRepository.save(movie);
        return "Added a new movie";
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }
}
