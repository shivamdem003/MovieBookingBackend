package com.cts.MovieBookingApp.service;

import com.cts.MovieBookingApp.exceptions.MovieExistsException;
import com.cts.MovieBookingApp.exceptions.MovieNotFoundException;
import com.cts.MovieBookingApp.model.Movie;
import com.cts.MovieBookingApp.repository.MovieRepository;
import com.cts.MovieBookingApp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private TicketRepository ticketRepo;

//    @Autowired
//    KafkaTemplate<String,Movie> kafkaTemplate;



    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieRepo.findAll();
        return movieList!=null && movieList.size()>0 ? movieList :null;
    }

    @Override
    public Movie addMovie(Movie movie) throws MovieExistsException, ParseException {

        Optional<Movie> opObj = movieRepo.findById(movie.getMovieId());
        if(opObj.isPresent()) {
            throw new MovieExistsException(movie.getMovieName(), movie.getMovieId());
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        movie.setDate(now);

//        try{kafkaTemplate.send("movieApp",movie);
//
//        }catch(Exception e){
//            System.out.println(e);
//        }
        return movieRepo.saveAndFlush(movie);
    }

    @Override
    public boolean deleteMovie(int mid) {
        movieRepo.deleteById(mid);
        return (movieRepo.findById(mid)!=null)?false:true;
    }

    @Override
    public boolean updateMovie(Movie movie) {
//        Movie updateMovie =movieRepo.findById(movie.getMovieId())
//                .orElseThrow(()-> new MovieNotFoundException(movie.getMovieId()));
        Movie updateMovie=movieRepo.getById(movie.getMovieId());

        if(movieRepo.getById(movie.getMovieId())==null){
            throw new MovieNotFoundException(movie.getMovieId());
        }else{
            updateMovie.setMovieId(movie.getMovieId());
            updateMovie.setMovieName(movie.getMovieName());
            updateMovie.setTheaterName(movie.getTheaterName());
            updateMovie.setSeatCount(movie.getSeatCount());
            movieRepo.saveAndFlush(updateMovie);
            return true;
        }
    }

    @Override
    public Movie getMovieById(int mid){
        Movie foundMovie = movieRepo.findById(mid)
                .orElseThrow(()-> new MovieNotFoundException(mid));
        return foundMovie!=null?movieRepo.saveAndFlush(foundMovie):null;
    }
}
