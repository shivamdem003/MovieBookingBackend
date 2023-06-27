package com.cts.MovieBookingApp.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Movie NOT_FOUND")
public class MovieNotFoundException extends RuntimeException{

    String movieName;
    int movieId;

    public MovieNotFoundException(int movieId){
        super(String.format("The Movie with Id :%s was not found",movieId));
        this.movieId=movieId;
        this.movieName=movieName;
    }


}
