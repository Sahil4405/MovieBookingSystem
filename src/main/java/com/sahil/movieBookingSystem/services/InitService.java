package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.exceptions.*;
/**
 * This will be used to initialize data in all the table of
 * the MBS
 */

public interface InitService {
    /**
     *This method when called will initialize the data in DB
     */
    public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException,
            TheatreDetailsNotFoundException, MovieTheatreDetailsNotFoundException,
            MovieDetailNotFoundException, UserDetailsNotFoundException;
}
