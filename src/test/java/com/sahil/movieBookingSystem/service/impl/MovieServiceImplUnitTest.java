package com.sahil.movieBookingSystem.service.impl;

import com.sahil.movieBookingSystem.dao.MovieDao;
import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.entities.Status;
import com.sahil.movieBookingSystem.services.impl.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplUnitTest {
    /**
     * MovieServiceImpl, it depends on movieDao
     *
     * We need to create a dummy of MovieDao and replace original MovieDao present in MovieServiceImpl
     */


    /**
     * This is the dummy/mock movieDao
     */
    @Mock
    private MovieDao movieDao;

    /**
     * This create the movieServiceImpl object with mocked moviedao
     */
    @InjectMocks
    private MovieServiceImpl movieService;


    Movie movie;

    @BeforeEach
    public void beforeTest(){

        movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Name1");
        movie.setMovieDescription("Desc1");
        movie.setCoverPhotoUrl("CP_URL");
        movie.setReleaseDate(LocalDateTime.of(2018,10,5,6,2));
        movie.setDuration(120);
        Status status = new Status();
        status.setStatusName("RELEASED");
        movie.setStatus(status);
        movie.setTrailerUrl("T_URL");

        /**
         * Adding the functionality on movieDao
         *
         * It says to MovieDao, when save method is called, just return the object back
         *
         * This doesn't involve actually calling of the database
         */
        Mockito.when(movieDao.save(movie)).thenReturn(movie);

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
}
