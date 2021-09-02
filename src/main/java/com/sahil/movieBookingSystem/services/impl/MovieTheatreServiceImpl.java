package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.MovieTheatreDao;
import com.sahil.movieBookingSystem.entities.MovieTheatre;
import com.sahil.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.MovieService;
import com.sahil.movieBookingSystem.services.MovieTheatreService;
import com.sahil.movieBookingSystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {
    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieTheatreDetailsNotFoundException, TheatreDetailsNotFoundException {
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id).orElseThrow(()-> new MovieTheatreDetailsNotFoundException("MovieTheatre is not found by id: "+id));
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre movieTheatre = getMovieTheatreDetails(id);
        movieTheatreDao.delete(movieTheatre);
        return true;
    }

    @Override
    public List<MovieTheatre> getAllMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }
}
