package com.example.lab_spring_cinema.controllers;

import com.example.lab_spring_cinema.models.Movie;
import com.example.lab_spring_cinema.models.MovieIO;
import com.example.lab_spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<String> addNewMovie(@RequestBody MovieIO movie){
        String addMovieStatus = movieService.addNewMovie(movie.getTitle(), movie.getRating(), movie.getDuration());
        return new ResponseEntity<>(addMovieStatus, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieIO> getMovieById(@PathVariable long id){
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if(movieOptional.isEmpty()){
            MovieIO movieIO = new MovieIO(
                    null,
                    null,
                    0.0);
            return new ResponseEntity<>(movieIO, HttpStatus.NOT_FOUND);
        }
        else {
            MovieIO movieIO = new MovieIO(
                    movieOptional.get().getTitle(),
                    movieOptional.get().getRating(),
                    movieOptional.get().getDuration()
            );
            return new ResponseEntity<>(movieIO, HttpStatus.OK);
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable long id, @RequestBody MovieIO newMovieInfo){
         String updateMovieStatus= movieService.updateMovie(
                id,
                newMovieInfo.getTitle(),
                newMovieInfo.getRating(),
                newMovieInfo.getDuration());
         return new ResponseEntity<>(updateMovieStatus, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable long id){
        return movieService.deleteMovieById(id);
    }

    @GetMapping(value = "/findby")
    public ResponseEntity<List<Movie>> getMoviesWithDurationLessThan(@RequestParam double duration){
        List<Movie> movies = movieService.getMovieWithDurationLessThan(duration);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


}
