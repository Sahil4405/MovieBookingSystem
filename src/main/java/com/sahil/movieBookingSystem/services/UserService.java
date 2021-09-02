package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.entities.User;
import com.sahil.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.sahil.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    /**
     * Allow the creation of users.
     * I should also not be allowed
     * 1. to create an existing/duplicate user
     * 2. I should not be allowed to create a user of Wrong
     */
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    /**
     * Fetch the user details based on the user ID
     */
    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    /**
     * Fetch the user by its name
     */
    public User getUserDetailsByName(String userName) throws UserDetailsNotFoundException;

    /**
     * Update the user
     */
    public User updateUserDetails(int id, User user) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;
}
