package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.ShowLocation;
import com.sutticket.sutticketmajor.repository.ShowLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ShowLocationController {

    @Autowired
    private final ShowLocationRepository showLocationRepository;

    public ShowLocationController(ShowLocationRepository showLocationRepository) {
        this.showLocationRepository = showLocationRepository;
    }

    @GetMapping("/showlocations")
    public Collection<ShowLocation> getShowLocations() {
        return showLocationRepository.findAll().stream().collect(Collectors.toList());
    }
}