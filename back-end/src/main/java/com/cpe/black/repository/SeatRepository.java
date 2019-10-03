package com.cpe.black.repository;

import com.cpe.black.entity.Seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findById(long id);
}