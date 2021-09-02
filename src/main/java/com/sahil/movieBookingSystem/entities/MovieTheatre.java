package com.sahil.movieBookingSystem.entities;

import javax.persistence.*;

@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieTheatreId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre; //theatre

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" +
                "movieTheatreId=" + movieTheatreId +
                ", movie=" + movie +
                ", theatre=" + theatre +
                '}';
    }
}
