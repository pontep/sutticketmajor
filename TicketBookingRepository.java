package com.ap.app.repository;

import com.ap.app.entity.TicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{
    
}