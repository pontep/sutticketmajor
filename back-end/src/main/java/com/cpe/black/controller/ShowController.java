package com.cpe.black.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.black.entity.Show;
import com.cpe.black.repository.ShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowController {

    @Autowired
    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping("/shows")
    public Collection<Show> getShows() {
        return showRepository.findAll().stream().collect(Collectors.toList());
    }
}