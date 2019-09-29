package com.ap.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ap.app.entity.Show;
import com.ap.app.repository.ShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ShowController{

    @Autowired
    ShowRepository showRepository;

    @GetMapping("/shows")
    public Collection<Show> getAllShows(){
        return showRepository.findAll().stream().collect(Collectors.toList());
    }

}