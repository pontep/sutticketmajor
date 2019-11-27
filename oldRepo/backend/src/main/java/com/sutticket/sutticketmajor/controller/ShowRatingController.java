package com.sutticket.sutticketmajor.controller;

import com.sutticket.sutticketmajor.entity.ShowRating;
import com.sutticket.sutticketmajor.repository.ShowRatingRepository;

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
public class ShowRatingController {

    @Autowired
    ShowRatingRepository showRatingRepository;


    @GetMapping("/Showratings")
    public Collection<ShowRating> getAllShowRatings() {
        return showRatingRepository.findAll().stream().collect(Collectors.toList());
    }



}
