package com.sahil.movieBookingSystem.service.impl;

import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.entities.Status;
import com.sahil.movieBookingSystem.services.impl.MovieServiceImpl;
import com.sahil.movieBookingSystem.services.impl.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * This class is used to write the test cases
 * of the MovieServiceImpl class
 */
@SpringBootTest
public class MovieServiceImplTest {
    /**
     * Tell spring to inject the dependency
     */
    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private StatusServiceImpl statusService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){

        movie = new Movie();
        movie.setMovieName("Name1");
        movie.setMovieDescription("Desc1");
        movie.setCoverPhotoUrl("CP_URL");
        movie.setReleaseDate(LocalDateTime.of(2018,10,5,6,2));
        movie.setDuration(120);
        Status status = new Status();
        status.setStatusName("RELEASED");

        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
        movie.setTrailerUrl("T_URL");

    }



    /**
     * Test acceptMovieDetails
     */
    @Test
    public void testAcceptMovieDetails(){
//        System.out.println("MovieService object: " + movieService);
        /**
         * Check if this method is able to save a movie details or not
         */
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getMovieId());
    }

    /**
     * Test getMovieDetails
     */

    /**
     * Test updateMovieDetails
     */

    /**
     * Test deleteMovie
     */
}
