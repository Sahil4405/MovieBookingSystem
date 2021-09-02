package com.sahil.movieBookingSystem.validators;

import com.sahil.movieBookingSystem.dtos.MovieDTO;
import com.sahil.movieBookingSystem.exceptions.MovieInvalidNameException;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOValidator{

    public void validate(MovieDTO movieDTO) throws MovieInvalidNameException {
        /**
         * Logic to validate the movieDTO object
         */
        if(movieDTO.getMovieName() == null || movieDTO.getMovieName().equals("")){
            throw new MovieInvalidNameException();
        }
    }
}
