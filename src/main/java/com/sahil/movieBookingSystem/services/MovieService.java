package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.exceptions.MovieDetailNotFoundException;

import java.util.List;

/**
 * This interface will define method supported by MovieService
 */
public interface MovieService {
    /**
     * It should be able to take a movie request and save it to database
     */
    public Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details based on the movie ID
     */
    public Movie getMovieDetails(int id) throws MovieDetailNotFoundException;

    /**
     * I want to update the details of existing movie
     */
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailNotFoundException;


    /**
     * Delete a movie
     */
    public boolean deleteMovie(int id) throws MovieDetailNotFoundException;

    /**
     * I want to get the list of all the movies present
     */
    public List<Movie> getAllMoviesDetails();

}
