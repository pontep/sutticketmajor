package com.ap.app.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ap.app.entity.Reason;
import com.ap.app.repository.ReasonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ReasonController{

    @Autowired
    ReasonRepository repository;

    @GetMapping("/rs")
    public Collection<Reason> getAllReasons(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/rs/{id}")
    public Optional<Reason> getAllReasons(@PathVariable Long id) {
        Optional<Reason> reason = repository.findById(id);
        return reason;
    }
    
}