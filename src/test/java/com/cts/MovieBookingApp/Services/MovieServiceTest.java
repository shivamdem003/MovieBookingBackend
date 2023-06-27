//package com.cts.MovieBookingApp.Services;
//
//import com.cts.MovieBookingApp.exceptions.MovieExistsException;
//import com.cts.MovieBookingApp.model.Movie;
//import com.cts.MovieBookingApp.service.MovieService;
//import com.cts.MovieBookingApp.service.MovieServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.internal.verification.Times;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//public class MovieServiceTest {
//    @Mock
//    private MovieService movieService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAllMovies() {
//        List<Movie> movies = new ArrayList<>();
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//
//        when(movieService.getAllMovies()).thenReturn(movies);
//
//        List<Movie> result = movieService.getAllMovies();
//
//        Assertions.assertEquals(movies, result);
//    }
//
//    @Test
//    public void testAddMovie() throws MovieExistsException, ParseException {
//        Movie movieToAdd = new Movie();
//
//        when(movieService.addMovie(movieToAdd)).thenReturn(movieToAdd);
//
//        Movie result = movieService.addMovie(movieToAdd);
//
//        Assertions.assertEquals(movieToAdd, result);
//        verify(movieService, times(1)).addMovie(movieToAdd);
//    }
//
//    @Test
//    public void testDeleteMovie() {
//        int movieIdToDelete = 1;
//
//        when(movieService.deleteMovie(movieIdToDelete)).thenReturn(true);
//
//        boolean result = movieService.deleteMovie(movieIdToDelete);
//
//        Assertions.assertTrue(result);
//        verify(movieService, times(1)).deleteMovie(movieIdToDelete);
//    }
//
//    @Test
//    public void testGetMovieById(){
//
//        Movie foundMovie= new Movie();
//        int movieIdToFind=1;
//
//        when(movieService.getMovieById(movieIdToFind)).thenReturn(foundMovie);
//
//        Movie result = movieService.getMovieById(movieIdToFind);
//        Assertions.assertEquals(foundMovie,result);
//
//    }
//
//    @Test
//    public void testUpdateMovie() {
//        Movie movieToUpdate = new Movie();
//
//        when(movieService.updateMovie(movieToUpdate)).thenReturn(true);
//
//        boolean result = movieService.updateMovie(movieToUpdate);
//
//        Assertions.assertTrue(result);
//        verify(movieService, times(1)).updateMovie(movieToUpdate);
//    }
//
//
//}
