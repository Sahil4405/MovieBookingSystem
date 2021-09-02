package com.sahil.movieBookingSystem.dao;

import com.sahil.movieBookingSystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
