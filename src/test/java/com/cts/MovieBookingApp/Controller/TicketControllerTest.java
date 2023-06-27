//package com.cts.MovieBookingApp.Controller;
//
//import com.cts.MovieBookingApp.controller.TicketController;
//import com.cts.MovieBookingApp.model.Movie;
//import com.cts.MovieBookingApp.model.Ticket;
//import com.cts.MovieBookingApp.service.MovieService;
//import com.cts.MovieBookingApp.service.TicketService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class TicketControllerTest {
//    @Mock
//    private MovieService movieService;
//
//    @Mock
//    private TicketService ticketService;
//
//    @InjectMocks
//    private TicketController ticketController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testBuyTicket() {
//        Ticket ticket = new Ticket();
//        ticket.setMovie_id_fk(1);
//        ticket.setMovieName("Movie 1");
//        ticket.setTheaterName("Theater 1");
//        ticket.setNoOfSeatsBooked(2);
//
//
//        Movie foundMovie = new Movie();
//        foundMovie.setMovieId(1);
//        foundMovie.setMovieName("Movie 1");
//        foundMovie.setTheaterName("Theater 1");
//
//        when(movieService.getMovieById(ticket.getMovie_id_fk())).thenReturn(foundMovie);
//        when(ticketService.buyTicket(ticket)).thenReturn(true);
//
//        ResponseEntity<?> responseEntity = ticketController.buyTciket(ticket);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Ticket Successfully Generated !!", responseEntity.getBody());
//    }
//
//    @Test
//    public void testBuyTicket_NoMovieFound() {
//        Ticket ticket = new Ticket();
//        ticket.setMovie_id_fk(1);
//        ticket.setMovieName("Movie 1");
//        ticket.setTheaterName("Theater 1");
//        ticket.setNoOfSeatsBooked(2);
//
//
//        when(movieService.getMovieById(ticket.getMovie_id_fk())).thenReturn(null);
//
//        ResponseEntity<?> responseEntity = ticketController.buyTciket(ticket);
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertEquals("Ticket not Created", responseEntity.getBody());
//    }
//
//    @Test
//    public void testGetAllTickets() {
//        List<Ticket> ticketList = new ArrayList<>();
//        ticketList.add(new Ticket(1, 1, "Transaction 1", "Movie Name", "Movie 1", 150, null));
//        ticketList.add(new Ticket(2, 2, "Transaction 2", "Movie Name", "Movie 2", 150, null));
//
//        when(ticketService.getAllTcikets()).thenReturn(ticketList);
//
//        ResponseEntity<List<Ticket>> responseEntity = ticketController.getAllTcikets();
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(ticketList, responseEntity.getBody());
//    }
//
//    @Test
//    public void testGetAllTickets_NoTicketsFound() {
//        when(ticketService.getAllTcikets()).thenReturn(null);
//
//        ResponseEntity<List<Ticket>> responseEntity = ticketController.getAllTcikets();
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals(null, responseEntity.getBody());
//    }
//
//
//}
