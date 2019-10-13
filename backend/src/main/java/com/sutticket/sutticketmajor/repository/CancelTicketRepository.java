package com.sutticket.sutticketmajor.repository;

import java.util.List;

import com.sutticket.sutticketmajor.entity.CancelTicket;
import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.TicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long>{
    CancelTicket findById(long id);
    List<CancelTicket> findByCustomer(Customer customer);
    CancelTicket findByTicketBooking(TicketBooking ticketBooking);
    @Query( value = "SELECT COUNT(cancelticket.ID) FROM cancelticket where cancelticket.CUSTOMER_ID = :customer_id",
            nativeQuery = true)
    long getCountById(@Param("customer_id") long customer_id);
}