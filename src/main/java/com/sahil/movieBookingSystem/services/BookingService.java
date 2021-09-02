package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.entities.Booking;
import com.sahil.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sahil.movieBookingSystem.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();
}
