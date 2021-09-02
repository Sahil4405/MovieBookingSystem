package com.sahil.movieBookingSystem.exceptionHandlers;

import com.sahil.movieBookingSystem.controllers.MovieController;
import com.sahil.movieBookingSystem.dtos.InvalidResponseDTO;
import com.sahil.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.sahil.movieBookingSystem.exceptions.MovieInvalidNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/**
 * 1. Create the bean of this class and make it available in Spring Container
 * 2. Every time ab exception is thrown this class will be informed
 */
public class MovieExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieExceptionHandler.class);

    /**
     * This annotation, indicate to this method, that if the given exception happens,
     * below method should be called
     * @return
     */
    @ExceptionHandler(value = MovieDetailNotFoundException.class)
    public ResponseEntity handleMovieNotFoundException(){
        LOGGER.error("Exception happened, movie id not available");
        return new ResponseEntity("Movie ID passed is not available", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MovieInvalidNameException.class)
    public ResponseEntity handleMovieNameInvalidException(){
        InvalidResponseDTO invalidResponseDTO = new InvalidResponseDTO("Movie name passed/ not correct", HttpStatus.BAD_REQUEST.toString(),"Movie resource");
//        return new ResponseEntity("Movie name not passed/ invalid",HttpStatus.BAD_REQUEST);

        return new ResponseEntity(invalidResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
