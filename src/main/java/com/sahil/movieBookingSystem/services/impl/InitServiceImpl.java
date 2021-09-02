package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.CityDao;
import com.sahil.movieBookingSystem.dao.LanguageDao;
import com.sahil.movieBookingSystem.dao.StatusDao;
import com.sahil.movieBookingSystem.dao.UserTypeDao;
import com.sahil.movieBookingSystem.entities.*;
import com.sahil.movieBookingSystem.exceptions.*;
import com.sahil.movieBookingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private CityDao cityDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private LanguageDao languageDao;

    @Autowired
    private StatusDao statusDao;

    @Autowired
    private UserService customerService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Autowired(required = true)
    private MovieTheatreService movieTheatreService;

    @Autowired
    private BookingService bookingService;

    List<City> cities = Arrays.asList(new City("Patna"), new City("Mumbai"), new City("Kolkata"), new City("Bangalore"));
    List<UserType> userTypes = Arrays.asList(new UserType("Customer"), new UserType("Admin"));
    List<Language> languages = Arrays.asList(new Language("English"), new Language("Hindi"));
    List<Status> statuses = Arrays.asList(new Status("Upcoming"), new Status("Released"), new Status("Blocked"));

    User customer = new User();
    Theatre theatre1 = new Theatre();
    Theatre theatre2 = new Theatre();
    Movie movie1 = new Movie();
    Movie movie2 = new Movie();
    MovieTheatre movieTheatre1 = new MovieTheatre();

    public void addCustomer() throws UserNameAlreadyExistsException,UserTypeDetailsNotFoundException{
        customer.setFirstName("Emma");
        customer.setLastName("Stone");
        customer.setUserName("emma123store");
        customer.setPassword("emma@amma");
        customer.setDateOfBirth(LocalDateTime.of(1988,11,6,0,0));
        customer.setUserType(userTypes.get(0));
        customer.setLanguage(languages.get(0));
        customer = customerService.acceptUserDetails(customer);
    }

    public void addTheatres(){
        theatre1.setTheatreName("Om Complex");
        theatre1.setTicketPrice(500);
        theatre1.setCity(cities.get(0));
        theatre1 = theatreService.acceptTheatreDetails(theatre1);

        theatre2.setTheatreName("Multiplex");
        theatre2.setTicketPrice(600);
        theatre2.setCity(cities.get(1));
        theatre2 = theatreService.acceptTheatreDetails(theatre2);
    }

    public void addMovies(){
        movie1.setMovieName("Avengers: Infinity War");
        movie1.setMovieDescription("The Avengers must stop Thanos, an intergalactic warlord, " +
                "from getting his hands on all the infinity stones.");
        movie1.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
        movie1.setDuration(150);
        movie1.setCoverPhotoUrl("cover-photo-url");
        movie1.setTrailerUrl("trailer-url");
        movie1.setStatus(statuses.get(0));
        movie1 = movieService.acceptMovieDetails(movie1);

        movie2.setMovieName("Avengers: Endgame");
        movie2.setMovieDescription("After Thanos, an intergalactic warlord, disintegrates half of " +
                "the universe, the Avengers must reunite and assemble again to reinvigorate their " +
                "trounced allies and restore balance.");
        movie2.setReleaseDate(LocalDateTime.of(2019, 4, 26, 5, 30));
        movie2.setDuration(180);
        movie2.setCoverPhotoUrl("cover-photo-url");
        movie2.setTrailerUrl("trailer-url");
        movie2.setStatus(statuses.get(1));
        movie2 = movieService.acceptMovieDetails(movie2);
    }

    private void addMovieTheatre() throws TheatreDetailsNotFoundException, MovieTheatreDetailsNotFoundException{

        movieTheatre1.setMovie(movie1);
        movieTheatre1.setTheatre(theatre2);
        movieTheatreService.acceptMovieTheatreDetails(movieTheatre1);
    }

    private void addBooking() throws UserDetailsNotFoundException, MovieTheatreDetailsNotFoundException {
        Booking booking = new Booking();
        booking.setBookingDate(LocalDateTime.of(2019, 1, 8, 0, 10));
        booking.setUser(customer);
        booking.setNoOfSeats(150);
        booking.setMovieTheatre(movieTheatre1);
        bookingService.acceptBookingDetails(booking);
    }



    @Override
    public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException, TheatreDetailsNotFoundException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        /**
         * Write the logic to store the data inside the database in different tables
         */

        cities.forEach(city -> cityDao.save(city));
        userTypes.forEach(userType -> userTypeDao.save(userType));
        languages.forEach(language -> languageDao.save(language));
        statuses.forEach(status -> statusDao.save(status));
        addCustomer();
        addTheatres();
        addMovies();
        addMovieTheatre();
        addBooking();

    }
}
