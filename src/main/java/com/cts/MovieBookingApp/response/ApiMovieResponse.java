package com.cts.MovieBookingApp.response;

import com.cts.MovieBookingApp.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiMovieResponse {

    private Movie movie;
    private String message;
    private boolean success;
    private ResponseEntity<?> statusCode;

}
