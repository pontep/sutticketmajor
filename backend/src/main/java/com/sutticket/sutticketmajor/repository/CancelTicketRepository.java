package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.CancelTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long>{
    
}