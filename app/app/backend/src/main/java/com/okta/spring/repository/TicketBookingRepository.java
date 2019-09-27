package com.okta.spring.repository;


import java.util.List;

import com.okta.spring.entity.Customer;
import com.okta.spring.entity.TicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{
    List<TicketBooking> findByCustomer(Customer customer);
    TicketBooking findById(long id);
}
