package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.UserDao;
import com.sahil.movieBookingSystem.entities.User;
import com.sahil.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.sahil.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.UserService;
import com.sahil.movieBookingSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if (userDao.findByUserName(user.getUserName()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());
        return userDao.save(user);
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id).orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public User getUserDetailsByName(String userName) throws UserDetailsNotFoundException {
        return userDao.findByUserName(userName).orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with username: " + userName));
    }

    @Override
    public User updateUserDetails(int id, User user) throws UserDetailsNotFoundException, UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        User savedUser = getUserDetails(id);
        if (userDao.findByUserName(user.getUserName()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());

        if (isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if (isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if (isNotNullOrZero(user.getUserName())) {
            savedUser.setUserName(user.getUserName());
        }

        if (isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }

        if (isNotNullOrZero(user.getDateOfBirth())) {
            savedUser.setDateOfBirth(user.getDateOfBirth());
        }

        if (isNotNullOrZero(user.getPhoneNumbers())) {
            savedUser.setPhoneNumbers(user.getPhoneNumbers());
        }

        if (isNotNullOrZero(user.getUserType())) {
            savedUser.setUserType(user.getUserType());
        }

        if (isNotNullOrZero(user.getLanguage())) {
            savedUser.setLanguage(user.getLanguage());
        }

        return userDao.save(savedUser);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
}
