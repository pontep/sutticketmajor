package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.entity.Customer;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{
    @Query( value = "SELECT a.* FROM TICKETBOOKING as a INNER JOIN  CANCELTICKET  
           as  p on a.TICKETBOOKING_ID != p.TICKETBOOKING_ID where a.CUSTOMER_ID=p.CUSTOMER_ID and a.CUSTOMER_ID = :customer_id",
            nativeQuery = true)
    Collection<TicketBooking> findByNotCancelTicket(@Param("customer_id") long customer_id);

    List<TicketBooking> findByCustomer(Customer customer);
    TicketBooking findById(long id);
    
    
}


