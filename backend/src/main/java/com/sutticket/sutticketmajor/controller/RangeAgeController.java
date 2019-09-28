package com.sutticket.sutticketmajor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.RangeAge;
import com.sutticket.sutticketmajor.repository.RangeAgeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RangeAgeController {

    @Autowired
    private RangeAgeRepository rangeAgeRepository;

    @GetMapping("/rangeage")
    public Collection<RangeAge> RangeAge() {
        return rangeAgeRepository.findAll().stream().collect(Collectors.toList());
    }

    

}