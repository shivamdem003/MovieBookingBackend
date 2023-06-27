package com.cts.MovieBookingApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "ticket_table")
public class Ticket {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int transcationalId;

    private int movie_id_fk;
    private String customerName;
    private String movieName;

    private String theaterName;
    private int noOfSeatsBooked;

    @JsonIgnore
    private Timestamp timestamp;
}
