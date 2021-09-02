package com.sahil.movieBookingSystem;

import com.sahil.movieBookingSystem.dao.MovieDao;
import com.sahil.movieBookingSystem.dao.StatusDao;
import com.sahil.movieBookingSystem.entities.Movie;
import com.sahil.movieBookingSystem.entities.Status;
import com.sahil.movieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.sahil.movieBookingSystem.services.InitService;
import com.sahil.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {

	/**
	 * We need the Logger Object
	 * @param args
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingSystemApplication.class);

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

//		MovieDao moviedao = ctx.getBean(MovieDao.class);
//		System.out.println(moviedao);

//		/**
//		 * I should be able to save the entity
//		 */
//		System.out.println(" ######## Creating Data for DB #######");
//		Movie movie = new Movie();
//		movie.setMovieName("Ki");
//		movie.setMovieDescription("Very nice Movie");
//		movie.setReleaseDate(LocalDateTime.of(2019,4,7,5,30));
//		movie.setDuration(150);
//		movie.setCoverPhotoUrl("cover-photo-url");
//		movie.setTrailerUrl("trailer-url");

//		Movie movie1 = new Movie();
//		movie1.setMovieName("Om");
//		movie1.setMovieDescription("Good Movie");
//		movie1.setReleaseDate(LocalDateTime.of(2015,4,7,5,30));
//		movie1.setDuration(200);
//		movie1.setCoverPhotoUrl("cover-photo-url");
//		movie1.setTrailerUrl("trailer-url");

//		Movie movie2 = new Movie();
//		movie2.setMovieName("Zid");
//		movie2.setMovieDescription("South India Movie");
//		movie2.setReleaseDate(LocalDateTime.of(2020,3,10,4,30));
//		movie2.setDuration(180);
//		movie2.setCoverPhotoUrl("cover-photo-url");
//		movie2.setTrailerUrl("trailer-url");


//		System.out.println("Movie object before storage: " + movie);
//
//		System.out.println(" ####### Going to save now in the DB ####### ");
//
//		Movie saveObject = moviedao.save(movie);
//
//		Movie saveObject1 = moviedao.save(movie1);
//
//		moviedao.save(movie2);
//
//		System.out.println("Save Object: "+saveObject);
//		System.out.println("Save Object1: "+saveObject1);

		/*
		 * I should be a ble to find movie using Id
		 */
//		Movie searchedMovie = moviedao.findById(1).get();
//		System.out.println("Searched Movie: " + searchedMovie);
//		movie.setMovieDescription("Updated Description");
//		moviedao.save(movie);

		/*
		 * I want to search movie by its name,,first we have to define a method on MovieDao, then we can use it here
		 */
//		List <Movie> searchByName = moviedao.findByMovieName("Zid");
//		System.out.println("Search by movie name: " + searchByName);

		/*
		 * I want to delete the movie
		 */
//		moviedao.delete(searchedMovie);

		/*
		 * I want to query based on the multiple columns
		 * query based on name and duration
		 */
//		List<Movie> srcByNameNDuration = moviedao.findByMovieNameAndDuration("Zid", 180);
//		System.out.println("Search by name and duration: " + srcByNameNDuration);


		/**
		 * Checking Service layer
		 */
//		MovieService movieService = ctx.getBean(MovieService.class);
//
//		StatusDao statusDao = ctx.getBean(StatusDao.class);
//
//		Status status = new Status();
//		status.setStatusName("RELEASED");
//
//		/**
//		 * Save the status
//		 */
//		statusDao.save(status);
//
//		Movie movie3 = new Movie();
//		movie3.setMovieDescription("Good Movie");
//		movie3.setMovieName("Story Of Gold in Olympics");
//		movie3.setTrailerUrl("trailer_url");
//		movie3.setDuration(120);
//		movie3.setReleaseDate(LocalDateTime.of(2020,1,2,4,20));
//		movie3.setCoverPhotoUrl("cover_url");
//		movie3.setStatus(status);
//
//		Movie storedM = movieService.acceptMovieDetails(movie3);
//		try {
//			movieService.getMovieDetails(storedM.getMovieId());
//		} catch (MovieDetailNotFoundException e) {
////			System.out.println(	e.toString());
//			e.printStackTrace();
//		}




		System.out.println("Hello Spring Boot !!!");


		/**
		 * Logger
		 */
		LOGGER.debug("Writing for debug"); //Debug and all below its will log
		LOGGER.info("Writing for info"); //info and all below it will log
		LOGGER.warn("Writing for info");
		LOGGER.error("Writing for info");
//		LOGGER.fata("Writing for info");

	}

	/**
	 * This is a way to execute something in the very begining when application is starting up
	 * @param initService
	 * @return
	 */
	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			System.out.println("This will be executed as soon as the application is started");
			initService.init();
		};
	}

	/**
	 * This will store the manually created object as a bean in the spring container
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}