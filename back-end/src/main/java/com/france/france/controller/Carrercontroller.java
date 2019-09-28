package com.france.france.controller;

import com.france.france.entity.Carrer;
import com.france.france.repository.Carrerrepository;

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
public class Carrercontroller {

    @Autowired
    private final Carrerrepository Carrerrepository;

    public Carrercontroller(Carrerrepository carrerrepository) {
        this.Carrerrepository = carrerrepository;
    }

    @GetMapping("/carrer")
    public Collection<Carrer> Carrer() {
        return Carrerrepository.findAll().stream().collect(Collectors.toList());
    }

}