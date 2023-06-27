package com.cts.MovieBookingApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success;
    private ResponseEntity statusCode;


    public ApiResponse(String message, boolean success, ResponseEntity status) {
        this.message=message;
        this.success=success;
        this.statusCode=status;
    }
}
