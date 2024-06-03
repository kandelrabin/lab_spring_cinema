package com.example.lab_spring_cinema.services;

import com.example.lab_spring_cinema.models.Movie;
import com.example.lab_spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public String updateMovie(long id, String newTitle, String newRating, double newDuration){
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(newTitle);
        movie.setRating(newRating);
        movie.setDuration(newDuration);
        movieRepository.save(movie);
        movieRepository.flush();
        return "Movie updated!";
    }

    public ResponseEntity<String> deleteMovieById(long id){
        Optional<Movie> movieOptional = this.getMovieById(id);
        if (movieOptional.isEmpty()){
            return new ResponseEntity<>("Movie is not in the list", HttpStatus.NOT_FOUND);
        } else{
            movieRepository.deleteById(id);
            movieRepository.flush();
            return new ResponseEntity<>("Movie deleted", HttpStatus.ACCEPTED);
        }
    }

    public List<Movie> getMovieWithDurationLessThan(double duration){
        return movieRepository.findMoviesWithDurationLessThan(duration);
    }


}
