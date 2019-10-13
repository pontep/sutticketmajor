package com.sutticket.sutticketmajor.repository;

import java.util.List;

import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.TicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//select * from ticketbooking where customer = '{{selectedCustomer}}'
@RepositoryRestResource
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{
    TicketBooking findById(long id);
    List<TicketBooking> findByCustomer(Customer customer);
}
