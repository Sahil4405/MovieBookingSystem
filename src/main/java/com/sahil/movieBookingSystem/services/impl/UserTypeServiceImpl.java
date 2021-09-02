package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.UserTypeDao;
import com.sahil.movieBookingSystem.entities.UserType;
import com.sahil.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    private UserTypeDao userTypeDao;

    @Override
    public UserType acceptUserTypeDetails(UserType userType) {
        return userTypeDao.save(userType);
    }

    @Override
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException {
        return userTypeDao.findById(id).orElseThrow(() -> new UserTypeDetailsNotFoundException("UserType not found with id: " + id));
    }

    @Override
    public UserType getUserTypeDetailsFromUserTypeName(String userTypeName) throws UserTypeDetailsNotFoundException {
        return userTypeDao.findByUserTypeName(userTypeName).orElseThrow(() -> new UserTypeDetailsNotFoundException("UserType not found with userTypeName: " + userTypeName));
    }

    @Override
    public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException {
        UserType userType = getUserTypeDetails(id);
        userTypeDao.delete(userType);
        return true;
    }

    @Override
    public List<UserType> getAllUserTypeDetails() {
        return userTypeDao.findAll();
    }
}
