package com.cts.MovieBookingApp.service;

import com.cts.MovieBookingApp.exceptions.TheaterFullException;
import com.cts.MovieBookingApp.exceptions.TicketNotFoundException;
import com.cts.MovieBookingApp.model.Ticket;
import com.cts.MovieBookingApp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieService movieService;


    @Override
    public Set<Ticket> getAllTicketList(int movieId) {
        return ticketRepository.getTickList(movieId);
    }

    @Override
    public boolean buyTicket(Ticket ticket) {

        Ticket updateTicket= new Ticket();

        updateTicket.setNoOfSeatsBooked(ticket.getNoOfSeatsBooked());
        updateTicket.setCustomerName(ticket.getCustomerName());
        updateTicket.setTranscationalId(ticket.getTranscationalId());
        updateTicket.setMovie_id_fk(ticket.getMovie_id_fk());
        updateTicket.setTimestamp(new Timestamp(System.currentTimeMillis()));

        int mid = ticket.getMovie_id_fk();
        updateTicket.setMovieName((movieService.getMovieById(mid)).getMovieName());
        updateTicket.setTheaterName((movieService.getMovieById(mid)).getTheaterName());
        if(movieService.getMovieById(mid).getSeatCount()>=ticket.getNoOfSeatsBooked()){
            movieService.getMovieById(mid).setSeatCount(movieService.getMovieById(mid).getSeatCount()-ticket.getNoOfSeatsBooked());
        }else {
            throw new TheaterFullException("Number of sits are not available",movieService.getMovieById(mid).getSeatCount(),ticket.getNoOfSeatsBooked());
        }

        ticketRepository.saveAndFlush(updateTicket);

        return true;
    }

    public boolean cancelTicket(int mid){
        ticketRepository.deleteTicket(mid);
        return true;
    }

    @Override
    public List<Ticket> getAllTcikets() {
        return ticketRepository.findAll();
    }


}
