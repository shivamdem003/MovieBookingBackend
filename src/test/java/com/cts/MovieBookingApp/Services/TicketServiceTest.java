//package com.cts.MovieBookingApp.Services;
//
//
//import com.cts.MovieBookingApp.model.Movie;
//import com.cts.MovieBookingApp.model.Ticket;
//import com.cts.MovieBookingApp.repository.TicketRepository;
//import com.cts.MovieBookingApp.service.MovieService;
//import com.cts.MovieBookingApp.service.MovieServiceImpl;
//import com.cts.MovieBookingApp.service.TicketService;
//import com.cts.MovieBookingApp.service.TicketServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//public class TicketServiceTest {
//
//    @Mock
//    private TicketRepository ticketRepository;
//
//    @Mock
//    private TicketService ticketService;
//
//    @Mock
//    private MovieService movieService;
//
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAllTicketList() {
//
//        List<Ticket> ticketList = new ArrayList<>();
//        ticketList.add(new Ticket());
//        ticketList.add(new Ticket());
//
//        when(ticketService.getAllTcikets()).thenReturn(ticketList);
//
//
//        List<Ticket> result = (List<Ticket>) ticketService.getAllTcikets();
//        Assertions.assertEquals(ticketList, result);
//
//    }
//
//    @Test
//    public void testBuyTicket() {
//        Movie movie = new Movie();
//        movie.setMovieId(1);
//        Ticket updatedTicket = new Ticket(1, 1, "shivam", "pokemon", "pokemaster", 5, null);
//
//        when(movieService.getMovieById(updatedTicket.getMovie_id_fk())).thenReturn(movie);
//        when(ticketRepository.saveAndFlush(updatedTicket)).thenReturn(updatedTicket);
//
//        boolean result = ticketService.buyTicket(updatedTicket);
//
//        Assertions.assertFalse(result);
//
//    }
//
//}
