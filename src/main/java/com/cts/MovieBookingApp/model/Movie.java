package com.cts.MovieBookingApp.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Movie {

    @Id
    private int movieId;
    private LocalDateTime date;
    private String movieName;
    private String theaterName;
    private int seatCount;


    @OneToMany(targetEntity = Ticket.class)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Ticket> ticketList;

    public Movie(int i, LocalDateTime now, String s, String s1, int i1) {
        this.movieId=i;
        this.date=now;
        this.movieName=s;
        this.theaterName=s1;
        this.seatCount=i1;
    }

}
