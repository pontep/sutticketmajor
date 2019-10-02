package com.sutticket.sutticketmajor.controller;

import com.sutticket.sutticketmajor.entity.Carrer;
import com.sutticket.sutticketmajor.repository.CarrerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CarrerController {

    @Autowired
    private final CarrerRepository carrerRepository;

    public CarrerController(CarrerRepository carrerRepository) {
        this.carrerRepository = carrerRepository;
    }

    @GetMapping("/carrer")
    public Collection<Carrer> Carrer() {
        return carrerRepository.findAll().stream().collect(Collectors.toList());
    }

}