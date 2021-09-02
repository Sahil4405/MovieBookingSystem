package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.BookingDao;
import com.sahil.movieBookingSystem.entities.Booking;
import com.sahil.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.BookingService;
import com.sahil.movieBookingSystem.services.MovieTheatreService;
import com.sahil.movieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    public MovieTheatreService movieTheatreService;

    @Autowired
    public UserService userService;

    @Autowired
    public BookingDao bookingDao;

    @Override
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException{
        movieTheatreService.getMovieTheatreDetails(booking.getMovieTheatre().getMovieTheatreId());
        userService.getUserDetails(booking.getUser().getCustomerId());
        bookingDao.save(booking);

        return booking;
    }

    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException{
        return bookingDao.findById(id).orElseThrow(() -> new BookingDetailsNotFoundException("Booking not found by id:" + id));
    }

    @Override
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException{
        Booking booking = getBookingDetails(id);
        bookingDao.delete(booking);

        return true;
    }

    @Override
    public List<Booking> getAllBookingDetails(){
        return bookingDao.findAll();
    }

}
