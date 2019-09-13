package com.ap.app.controller;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.ap.app.entity.TicketBooking;
import com.ap.app.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class TicketBookingController{

    @Autowired
    TicketBookingRepository repository;

    @GetMapping("/tb")
    public Collection<TicketBooking> getAllTicketBookings(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
    
}