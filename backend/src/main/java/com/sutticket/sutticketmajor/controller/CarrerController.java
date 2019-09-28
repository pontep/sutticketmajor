package com.sutticket.sutticketmajor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Carrer;
import com.sutticket.sutticketmajor.repository.CarrerRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CarrerController {

    @Autowired
    CarrerRepository carrerRepository;

    @GetMapping("/carrer")
    public Collection<Carrer> Carrer() {
        return carrerRepository.findAll().stream().collect(Collectors.toList());
    }

}