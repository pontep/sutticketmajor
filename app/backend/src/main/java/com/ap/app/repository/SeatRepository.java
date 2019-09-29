package com.ap.app.repository;



import com.ap.app.entity.Seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat, Long>{
    Seat findById(long id);
}