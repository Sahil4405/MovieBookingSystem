package com.sahil.movieBookingSystem.dao;

import com.sahil.movieBookingSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
* Learn about CRUDRepository Also,, similar to JpaRepository,
* JpaRepository is little mmore extend of CRUDRepository
*/
public interface MovieDao extends JpaRepository<Movie, Integer> {

    /**
     * I also want to support the search based on the movie name
     */
    public List<Movie> findByMovieName(String movieName);

    /**
     * I want to query based on the multiple columns
     * query based on name and duration
     */
    public List<Movie> findByMovieNameAndDuration(String name, int duration);

    /*
     * Find the movie greater duration than given hour
     */
//    public List<Movie> findByDurationGreaterThanEqual(int duration);
}
