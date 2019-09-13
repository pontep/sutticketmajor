package com.ap.app.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ap.app.entity.CancelTicket;
import com.ap.app.repository.CancelTicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CancelTicketController{

    @Autowired
    CancelTicketRepository repository;
    
    @GetMapping("/ct")
    public Collection<CancelTicket> getAllCancelTicket(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/ct/{id}")
    public Optional<CancelTicket> getAllCancelTicket(@PathVariable Long id) {
        Optional<CancelTicket> cancelticket = repository.findById(id);
        return cancelticket;
    }


}