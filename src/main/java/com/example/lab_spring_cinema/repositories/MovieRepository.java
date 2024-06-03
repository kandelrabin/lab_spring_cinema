package com.example.lab_spring_cinema.repositories;

import com.example.lab_spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.duration < :duration")
    List<Movie> findMoviesWithDurationLessThan(@Param("duration") double duration);
}
