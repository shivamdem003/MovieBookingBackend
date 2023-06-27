package com.cts.MovieBookingApp.service;

import com.cts.MovieBookingApp.exceptions.MovieExistsException;
import com.cts.MovieBookingApp.model.Movie;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    public List<Movie> getAllMovies();

    public Movie addMovie(Movie movie) throws MovieExistsException, ParseException;

    public boolean deleteMovie(int mid);

    public boolean updateMovie(Movie movie);

    public Movie getMovieById(int mid);
}
