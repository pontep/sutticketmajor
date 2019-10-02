package com.sutticket.sutticketmajor.controller;

import com.sutticket.sutticketmajor.entity.RangeAge;
import com.sutticket.sutticketmajor.repository.RangeAgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RangeAgeController {

    @Autowired
    private final RangeAgeRepository rangeageRepository;

    public RangeAgeController(RangeAgeRepository rangeageRepository) {
        this.rangeageRepository = rangeageRepository;
    }

    @GetMapping("/rangeage")
    public Collection<RangeAge> RangeAge() {
        return rangeageRepository.findAll().stream().collect(Collectors.toList());
    }

    

}