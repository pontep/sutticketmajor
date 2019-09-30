package com.sutticket.sutticketmajor.repository;

import java.util.List;

import com.sutticket.sutticketmajor.entity.CancelTicket;
import com.sutticket.sutticketmajor.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long>{
    CancelTicket findById(long id);
    List<CancelTicket> findByCustomer(Customer customer);
}