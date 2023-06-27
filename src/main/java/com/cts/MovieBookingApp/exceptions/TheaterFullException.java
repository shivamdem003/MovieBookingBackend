package com.cts.MovieBookingApp.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code= HttpStatus.FORBIDDEN, reason="HOUSE_FULL")
public class TheaterFullException extends RuntimeException{

    private String message;
    private int currentSeats;
    private int requestedSeats;

    public TheaterFullException(String message, int currentSeats,int requestedSeats){
        super(String.format("%s :: available seats:%s , requested seats:%s",message,currentSeats,requestedSeats));

    }

}
