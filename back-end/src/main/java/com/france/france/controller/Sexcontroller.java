package com.france.france.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.france.france.entity.Sex;
import com.france.france.repository.Sexrepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Sexcontroller {

    @Autowired
    private final Sexrepository sexrepository;

    public Sexcontroller(Sexrepository sexrepository) {
        this.sexrepository = sexrepository;
    }

    @GetMapping("/sex")
    public Collection<Sex> Sex() {
        return sexrepository.findAll().stream().collect(Collectors.toList());
    }

}