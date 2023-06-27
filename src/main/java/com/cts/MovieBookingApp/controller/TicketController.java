package com.cts.MovieBookingApp.controller;

import com.cts.MovieBookingApp.model.Movie;
import com.cts.MovieBookingApp.model.Ticket;
import com.cts.MovieBookingApp.response.ApiResponse;
import com.cts.MovieBookingApp.response.ApiTicketResponse;
import com.cts.MovieBookingApp.service.MovieService;
import com.cts.MovieBookingApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/moviebooking")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private MovieService ms;

    @Autowired
    private TicketService ts;

    @PostMapping("/book")
    public ResponseEntity<?> buyTciket(
            @RequestBody Ticket ticket){
            System.out.println("hit hit hit");

            Movie foundMovie = ms.getMovieById(ticket.getMovie_id_fk());


        if(foundMovie!=null){
            //foundMovie.setTicketList();
           ticket.setMovieName(ticket.getMovieName());
           ticket.setNoOfSeatsBooked(ticket.getNoOfSeatsBooked());
           ticket.setTheaterName(ticket.getTheaterName());
           ticket.setTranscationalId(ticket.getTranscationalId());
           ticket.setMovie_id_fk(ticket.getMovie_id_fk());
           if(ts.buyTicket(ticket)){
               return new ResponseEntity<ApiTicketResponse>(new ApiTicketResponse("Ticket Successfully Generated!!",new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK);
           }
        }
        return new ResponseEntity<ApiTicketResponse>(new ApiTicketResponse("Ticket not Created",new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @DeleteMapping("/ticketDelete/{tid}")
    public void deleteTiket(@PathVariable("tid") int mid){
        ts.cancelTicket(mid);
    }

    @GetMapping("/listAllTickets")
    public ResponseEntity<List<Ticket>> getAllTcikets(){
        return (ts.getAllTcikets()!=null)?new ResponseEntity<List<Ticket>>(ts.getAllTcikets(),HttpStatus.OK)
                :new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
