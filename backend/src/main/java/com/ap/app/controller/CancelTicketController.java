package com.ap.app.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ap.app.entity.CancelTicket;
import com.ap.app.entity.Customer;
import com.ap.app.entity.TicketBooking;
import com.ap.app.entity.Reason;
import com.ap.app.repository.CancelTicketRepository;
import com.ap.app.repository.CustomerRepository;
import com.ap.app.repository.TicketBookingRepository;
import com.ap.app.repository.ReasonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CancelTicketController{

    @Autowired
    private CancelTicketRepository cancelticketRepository;
    @Autowired
    private CustomerRepository  customerRepository;
    @Autowired
    private TicketBookingRepository ticketBookingRepository;
    @Autowired
    private ReasonRepository reasonRepository;
    
    @GetMapping("/ct")
    public Collection<CancelTicket> getAllCancelTickets(){
        return cancelticketRepository.findAll().stream().collect(Collectors.toList());
    }

     

     @PostMapping("/ct/{customer_id}/{ticketbooking_id}/{reason_id}")
     public CancelTicket postCancelTicket(CancelTicket newCancelTicket, 
        @PathVariable long customer_id,
        @PathVariable long ticketbooking_id, 
        @PathVariable long reason_id) {

        Customer customer = customerRepository.findById(customer_id);
        TicketBooking ticketbooking = ticketBookingRepository.findById(ticketbooking_id);
        Reason reason = reasonRepository.findById(reason_id);

        newCancelTicket.setCustomer(customer);
        newCancelTicket.setTicketbooking(ticketbooking);
        newCancelTicket.setReason(reason);
        newCancelTicket.setCancelDate(new Date());

        return cancelticketRepository.save(newCancelTicket);

    }

    
}