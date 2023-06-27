package com.cts.MovieBookingApp.controller;


import com.cts.MovieBookingApp.exceptions.MovieExistsException;
import com.cts.MovieBookingApp.model.Movie;
import com.cts.MovieBookingApp.model.Ticket;
import com.cts.MovieBookingApp.response.ApiMovieResponse;
import com.cts.MovieBookingApp.response.ApiResponse;
import com.cts.MovieBookingApp.service.MovieService;
import com.cts.MovieBookingApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/moviebooking")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> movieList = movieService.getAllMovies();
        if(movieList!=null){
           for(Movie m: movieList){
               Set<Ticket> ticketList = ticketService.getAllTicketList(m.getMovieId());
               m.setTicketList(ticketList);
           }
           return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse("List is Empty",true,new ResponseEntity<>(HttpStatus.OK)), HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws MovieExistsException, ParseException {
        Movie addedMovie =movieService.addMovie(movie);
        return addedMovie!=null ? new ResponseEntity<ApiResponse>(new ApiResponse("Movie Added Successfully",true,new ResponseEntity<>(HttpStatus.CREATED)),HttpStatus.CREATED):
                new ResponseEntity<ApiResponse>(new ApiResponse("Movie Could not be added",false,new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{mid}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("mid") int movieid) {
        return (ticketService.cancelTicket(movieid) & movieService.deleteMovie(movieid)) ? new ResponseEntity<ApiResponse>(new ApiResponse("Movie & Tickets Deleted Succsfully",true,new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK)
                : new ResponseEntity<ApiResponse>(new ApiResponse("Movie could not be deleted",true,new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK);
    }


    @GetMapping("/movies/search/{mid}")
    public ResponseEntity<?> getMovieById(@PathVariable("mid") int movieId){
        Movie foundMovie = movieService.getMovieById(movieId);
        return foundMovie!=null?
                new ResponseEntity<Movie>(foundMovie,HttpStatus.FOUND):
                new ResponseEntity<ApiResponse>(new ApiResponse("Movie Not Found!!",false,new ResponseEntity<>(HttpStatus.NOT_FOUND)),HttpStatus.NOT_FOUND);
    }


    @PutMapping("/updateMovie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        boolean updatedMovie = movieService.updateMovie(movie);
        return updatedMovie?new ResponseEntity<ApiMovieResponse>(new ApiMovieResponse(movie,"Movie Updated",true,new ResponseEntity<>(HttpStatus.OK)), HttpStatus.OK):
                new ResponseEntity<String>("book could not be updated", HttpStatus.OK);
    }




}
