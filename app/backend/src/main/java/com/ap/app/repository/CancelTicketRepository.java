package com.ap.app.repository;

import com.ap.app.entity.CancelTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long>{
    
}