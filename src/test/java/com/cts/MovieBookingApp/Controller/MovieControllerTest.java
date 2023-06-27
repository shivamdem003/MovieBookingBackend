//package com.cts.MovieBookingApp.Controller;
//
//import com.cts.MovieBookingApp.controller.MovieController;
//import com.cts.MovieBookingApp.exceptions.MovieExistsException;
//import com.cts.MovieBookingApp.model.Movie;
//import com.cts.MovieBookingApp.model.Ticket;
//import com.cts.MovieBookingApp.response.ApiMovieResponse;
//import com.cts.MovieBookingApp.response.ApiResponse;
//import com.cts.MovieBookingApp.service.MovieService;
//import com.cts.MovieBookingApp.service.TicketService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.text.ParseException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//public class MovieControllerTest {
//
//    @Mock
//    private MovieService movieService;
//
//    @Mock
//    private TicketService ticketService;
//
//    @InjectMocks
//    private MovieController movieController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//
//    @Test
//    public void testGetAllMovies() {
//        List<Movie> movieList = new ArrayList<>();
//        movieList.add(new Movie(1, LocalDateTime.now(), "Movie 1", "Theater 1", 10));
//        movieList.add(new Movie(2,LocalDateTime.now(),"Movie 2", "Theater 2", 8));
//
//        Set<Ticket> ticketList = new HashSet<>();
//        ticketList.add(new Ticket(1, 1, "Transaction 1","Movie 1" , "Theater 1", 4, null));
//        ticketList.add(new Ticket(2, 2, "Transaction 2", "Movie 2", "Theater 2", 2, null));
//
//        when(movieService.getAllMovies()).thenReturn(movieList);
//        when(ticketService.getAllTicketList(anyInt())).thenReturn(ticketList);
//
//        ResponseEntity<?> responseEntity = movieController.getAllMovies();
//
//        assertEquals(movieList,responseEntity.getBody());
//
//    }
//
//    @Test
//    public void testGetAllMovies_null() {
//        List<Movie> movieList = new ArrayList<>();
//
//        when(movieService.getAllMovies()).thenReturn(movieList);
//
//
//        ResponseEntity<?> responseEntity = movieController.getAllMovies();
//
//        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
//        assertEquals(movieList,responseEntity.getBody());
//
//    }
//
//    @Test
//    public void testAddMovie() throws MovieExistsException, ParseException {
//        Movie movieToAdd = new Movie();
//        movieToAdd.setMovieId(1);
//        movieToAdd.setMovieName("Movie_name");
//        movieToAdd.setTheaterName("Theater_name");
//        movieToAdd.setSeatCount(100);
//        ApiResponse successResponse = new ApiResponse("Movie Added Successfully", true, null);
//        ApiResponse failureResponse = new ApiResponse("Movie Could not be added", false, null);
//
//        when(movieService.addMovie(movieToAdd)).thenReturn(movieToAdd);
//
//        ResponseEntity<?> responseEntity = movieController.addMovie(movieToAdd);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
////        assertEquals(successResponse,responseEntity.getBody());
//
//    }
//
//    @Test
//    public void testDeleteMovieById() {
//        int movieId = 1;
//        ApiResponse successResponse = new ApiResponse("Movie & Tickets Deleted Successfully", true, null);
//        ApiResponse failureResponse = new ApiResponse("Movie could not be deleted", true, null);
//
//        when(ticketService.cancelTicket(movieId)).thenReturn(true);
//        when(movieService.deleteMovie(movieId)).thenReturn(true);
//
//        Boolean responseEntity = movieController.deleteMovieById(movieId).hasBody();
//        assertTrue(responseEntity);
//
//    }
//
//    @Test
//    public void testGetMovieById() {
//        int movieId = 1;
//        Movie movie = new Movie();
//        movie.setMovieId(1);
//        movie.setMovieName("MovieTest");
//        ApiResponse failureResponse = new ApiResponse("Movie Not Found!!", false, null);
//
//        when(movieService.getMovieById(movieId)).thenReturn(movie);
//
//        ResponseEntity<?> responseEntity = movieController.getMovieById(movieId);
//
//        assertEquals(movie,responseEntity.getBody());
//    }
//
//    @Test
//    public void testUpdateMovie() {
//        //Checking pending for this
//        Movie movieToUpdate = new Movie();
//        movieToUpdate.setMovieId(1);
//        movieToUpdate.setMovieName("MovieTest");
//        ApiMovieResponse failureResponse = new ApiMovieResponse(movieToUpdate, "Movie Not Found!!", false, null);
//
//        when(movieService.updateMovie(movieToUpdate)).thenReturn(false);
//
//        boolean responseEntity = movieService.updateMovie(movieToUpdate);
//
//       assertFalse(responseEntity);
//
//    }
//
//
//}
