package com.sutticket.sutticketmajor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.TypeShow;
import com.sutticket.sutticketmajor.repository.TypeShowRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class TypeShowController {

    @Autowired
    TypeShowRepository typeShowRepository;

    

    @GetMapping("/typeShows")
    public Collection<TypeShow> getAllTypeShows() {
        return typeShowRepository.findAll().stream().collect(Collectors.toList());
    }

}