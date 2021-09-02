package com.sahil.movieBookingSystem.dao;

import com.sahil.movieBookingSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    public Optional<User> findByUserName(String userName);
}
