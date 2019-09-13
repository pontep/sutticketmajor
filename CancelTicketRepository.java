package com.ap.app.repository;

import com.ap.app.entity.CancelTicket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long>{
    
}