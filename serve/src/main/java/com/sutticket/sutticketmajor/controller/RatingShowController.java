package com.sutticket.sutticketmajor.controller;

import com.sutticket.sutticketmajor.entity.RatingShow;
import com.sutticket.sutticketmajor.repository.RatingShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RatingShowController {

    @Autowired
     RatingShowRepository ratingShowRepository;


    @GetMapping("/ratingShows")
    public Collection<RatingShow> getAllRatingShows() {
        return ratingShowRepository.findAll().stream().collect(Collectors.toList());
    }



}
