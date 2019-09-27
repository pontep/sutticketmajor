package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.TicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{

}
