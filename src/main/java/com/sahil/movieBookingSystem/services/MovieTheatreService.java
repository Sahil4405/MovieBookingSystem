package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.entities.MovieTheatre;
import com.sahil.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieTheatreDetailsNotFoundException, TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
}
