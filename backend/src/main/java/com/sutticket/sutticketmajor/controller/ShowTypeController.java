package com.sutticket.sutticketmajor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.ShowType;
import com.sutticket.sutticketmajor.repository.ShowTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class ShowTypeController {

    @Autowired
    ShowTypeRepository showTypeRepository;

    

    @GetMapping("/Showtypes")
    public Collection<ShowType> getAllShowTypes() {
        return showTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}
