package com.france.france.controller;

import com.france.france.entity.RangeAge;
import com.france.france.repository.RangeAgerepository;
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
public class RangeAgecontroller {

    @Autowired
    private final RangeAgerepository rangeagerepository;

    public RangeAgecontroller(RangeAgerepository rangeagerepository) {
        this.rangeagerepository = rangeagerepository;
    }

    @GetMapping("/rangeage")
    public Collection<RangeAge> RangeAge() {
        return rangeagerepository.findAll().stream().collect(Collectors.toList());
    }

    

}