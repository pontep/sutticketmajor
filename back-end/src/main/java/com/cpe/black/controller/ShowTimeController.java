package com.cpe.black.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.black.entity.ShowTime;
import com.cpe.black.repository.ShowTimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowTimeController {

    @Autowired
    private final ShowTimeRepository showTimeRepository;

    public ShowTimeController(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    @GetMapping("/showtime")
    public Collection<ShowTime> ShowTimes() {
        return showTimeRepository.findAll().stream().collect(Collectors.toList());
    }
}