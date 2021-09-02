package com.sahil.movieBookingSystem.controllers;

import com.sahil.movieBookingSystem.dtos.MovieDTO;
import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.sahil.movieBookingSystem.exceptions.MovieInvalidNameException;
import com.sahil.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.MovieService;
import com.sahil.movieBookingSystem.validators.MovieDTOValidator;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * End Point
 *root path -> /mbs/v1   |  sorted
 * 127.0.0.1:8080/mbs/v1/movies
 */
@RestController
/**
 * @RestController working
 * 1. @Component
 * 2. Give hints to spring that whenever a REST call comes, make sure this class is informed
 */
@RequestMapping("/movies")
/**
 * Before @RequestMapping
 * 127.0.0.1:8080/mbs/v1
 *
 * After @RequestMapping
 * this will result in the creation of 127.0.0.1:8080/mbs/v1/movies
 */
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDTOValidator movieDTOValidator;

    /**
     * we need to define the bean of modelMapper first
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * GET 127.0.0.1:8080/mbs/v1/movies/greetings
     *
     * should get "Hello people"
     */
    @GetMapping("/greetings")
    /**
     * Before @GetMapping
     * 127.0.0.1:8080/mbs/v1/movies
     *
     * After @GetMapping
     * 127.0.0.1:8080/mbs/v1/movies/greetings
     */
    public ResponseEntity helloWorld(){

        LOGGER.info("Inside the hello World Method");
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }


    /**
     * Get all the movies
     *
     * GET 127.0.0.1:8080/mbs/v1/movies
     */
    @GetMapping
    public ResponseEntity getAllMovies(){
        /**
         * First get all the movies
         */
        List<Movie> movies = movieService.getAllMoviesDetails();

        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie movie : movies){
            movieDTOS.add(convertToMovieDTO(movie));
        }

        /**
         * Wrap inside the ResponseEntity
         */

        return new ResponseEntity(movieDTOS,HttpStatus.OK);
    }

    /**
     * Get the movie details based on the id
     *
     * GET 127.0.0.1:8082:mbs/v1/movies/{movieId}
     *
     */
    @GetMapping("/{movieId}")
    public ResponseEntity getMoviesBasedOnId(@PathVariable(name = "movieId") int movieId) throws MovieTheatreDetailsNotFoundException, MovieDetailNotFoundException {
//        Movie movie = null;
//        try{
//            movie = movieService.getMovieDetails(movieId);
//        }catch(MovieDetailNotFoundException e){
//            LOGGER.error("Bad request found for the id: " + movieId);
//            LOGGER.error("Error stack trace : " + e.getMessage());
//            return new ResponseEntity("movieId : [ " + movieId + " ] passed is not correct",HttpStatus.BAD_REQUEST);
//        }

        /**
         * Now instead of using try and catch we will use AOP,,
         *
         */
        Movie movie = movieService.getMovieDetails(movieId);

        /**
         * Convert the movie object to MovieDTO object
         */
        MovieDTO movieDTO = convertToMovieDTO(movie);

        /**
         * I should not use, Movie class  to return response to the client
         */
        return new ResponseEntity(movieDTO,HttpStatus.OK);
    }

    /**
     * I want to create a new movie
     *
     * POST 127.0.0.1:8080/mbs/v1/movies
     *
     * This method expects some request body
     *
     * @param
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) throws MovieInvalidNameException {

        /**
         * Validating the request body
         */
        //Write the code of the validation of the MovieDTO in the class

        movieDTOValidator.validate(movieDTO);

        //I need to create the new movie
        //I need to create Movie object from MovieDTO object
        Movie movie = modelMapper.map(movieDTO,Movie.class);

        Movie savedMovie = movieService.acceptMovieDetails(movie);

        //Again I need to convert it back to MovieDto to send back to client
        MovieDTO responseBody = modelMapper.map(savedMovie,MovieDTO.class);

        return new ResponseEntity(responseBody,HttpStatus.CREATED);
    }

    /**
     * I would like to update already created existing movie
     * PUT 127.0.0.1:8080/mbs/v1/movies/{movieId}
     * JSON body has to be passed
     * @param
     * @return
     */
    @PutMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,@PathVariable(name = "movieId") int movieId) throws MovieDetailNotFoundException {

        /**
         * First check if the movie is present in the system or not
         *
         */
        Movie storedMovie = movieService.getMovieDetails(movieId);

        Movie movieToBeUpdated = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.updateMovieDetails(movieId,movieToBeUpdated);

        MovieDTO savedResponse = modelMapper.map(savedMovie,MovieDTO.class);

        return new ResponseEntity(savedResponse,HttpStatus.ACCEPTED);
    }

    /**
     * DELETE 127.0.0.1:8080/mbs/v1/movies/{movieId}
     * @param
     * @return
     */
    @DeleteMapping(value = "/{movie_id}")
    public ResponseEntity deleteMovie(@PathVariable(name = "movie_id") int id) throws MovieDetailNotFoundException {
        movieService.deleteMovie(id);

        return new ResponseEntity("DELETED",HttpStatus.OK);
    }


    private MovieDTO convertToMovieDTO(Movie movie) {
//        MovieDTO movieDTO = new MovieDTO();
//        movieDTO.setMovieId(movie.getMovieId());
//        movieDTO.setMovieName(movie.getMovieName());
//        movieDTO.setMovieDescription(movie.getMovieDescription());
//        movieDTO.setDuration(movie.getDuration());
//        movieDTO.setReleaseDate(movie.getReleaseDate());
//        movieDTO.setCoverPhotoUrl(movie.getCoverPhotoUrl());
//        movieDTO.setTrailerUrl(movie.getTrailerUrl());
//        movieDTO.setStatusId(movie.getStatus().getStatusId());

        MovieDTO movieDTO = modelMapper.map(movie,MovieDTO.class);

        return movieDTO;
    }
}
