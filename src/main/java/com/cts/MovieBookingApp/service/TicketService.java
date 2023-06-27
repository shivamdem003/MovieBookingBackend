package com.cts.MovieBookingApp.service;

import com.cts.MovieBookingApp.model.Ticket;

import java.util.List;
import java.util.Set;

public interface TicketService {

    public Set<Ticket> getAllTicketList(int movieId);

    public boolean buyTicket(Ticket ticket);

    public boolean cancelTicket(int mid);

    public List<Ticket> getAllTcikets();

}
