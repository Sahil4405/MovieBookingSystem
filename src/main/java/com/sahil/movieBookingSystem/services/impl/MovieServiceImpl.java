package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.MovieDao;
import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.sahil.movieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    /**
     * To talk with the database, I need the help of MovieDao
     */
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        /**
         * With the help of MovieDao save into DB
         */
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailNotFoundException {
        /**
         * Fetch movie details based on the id
         */
        return movieDao.findById(id).orElseThrow(() -> new MovieDetailNotFoundException("Movie not found for id" + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailNotFoundException {
        /**
         * Update the movie
         */
        Movie savedMovie = movieDao.findById(id).orElseThrow(() -> new MovieDetailNotFoundException("Movie not found for id" + id));

        /**
         * Read the attributes from the movie objects and update it in savedMovie
         */
        if(isNotNullOrZero(movie.getMovieName())){
            savedMovie.setMovieName(movie.getMovieName());
        }
        if(isNotNullOrZero(movie.getMovieDescription())){
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }

        if(isNotNullOrZero(movie.getDuration())){
            savedMovie.setDuration(movie.getDuration());
        }

        if(isNotNullOrZero(movie.getCoverPhotoUrl())){
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }

        if(isNotNullOrZero(movie.getReleaseDate())){
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        if(isNotNullOrZero(movie.getStatus())){
            savedMovie.setStatus(movie.getStatus());
        }

        if(isNotNullOrZero(movie.getTrailerUrl())){
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }

        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj){
        return obj!=null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDao.findAll();
    }
}
