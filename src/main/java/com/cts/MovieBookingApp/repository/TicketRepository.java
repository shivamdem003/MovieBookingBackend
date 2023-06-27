package com.cts.MovieBookingApp.repository;

import com.cts.MovieBookingApp.model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query(value="select r from Ticket r where r.movie_id_fk= :movieId")
    public Set<Ticket> getTickList(int movieId);


    @Modifying
    @Query(value="delete from Ticket where movie_id_fk= :movieId")
    public void deleteTicket(int movieId);

}
