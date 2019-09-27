package com.cpe.black.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.black.entity.ShowLocation;
import com.cpe.black.repository.ShowLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowLocationController {

    @Autowired
    private final ShowLocationRepository showLocationRepository;

    public ShowLocationController(ShowLocationRepository showLocationRepository) {
        this.showLocationRepository = showLocationRepository;
    }

    @GetMapping("/showlocation")
    public Collection<ShowLocation> ShowLocations() {
        return showLocationRepository.findAll().stream().collect(Collectors.toList());
    }
}