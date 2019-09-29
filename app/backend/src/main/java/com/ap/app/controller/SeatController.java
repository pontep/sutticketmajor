package com.ap.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ap.app.entity.Seat;
import com.ap.app.repository.SeatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class SeatController{

    @Autowired
    SeatRepository seatRepository;
    
    @GetMapping("/seats")
    public Collection<Seat> getAllSeats(){
        return seatRepository.findAll().stream().collect(Collectors.toList());
    }

}