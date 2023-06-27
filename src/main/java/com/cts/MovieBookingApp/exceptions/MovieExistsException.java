package com.cts.MovieBookingApp.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code= HttpStatus.CONFLICT, reason="Movie DUPLICATION_EXCEPTION")
public class MovieExistsException extends Exception{

    String movieName;
    int movieId;

    public MovieExistsException(String movieName, int movieId){
        super(String.format("The Movie %s can not be added cause movie associated with Id :%s already Present",movieName,movieId));
        this.movieId=movieId;
        this.movieName=movieName;
    }

}
