package com.cts.MovieBookingApp.response;

import com.cts.MovieBookingApp.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiTicketResponse {

    private String message;
    private ResponseEntity<?> statusCode;

}
