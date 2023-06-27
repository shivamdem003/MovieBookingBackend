package com.cts.MovieBookingApp.repository;

import com.cts.MovieBookingApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional // ACID Properties enabled
public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
