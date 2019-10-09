package com.sutticket.sutticketmajor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.sutticket.sutticketmajor.entity.Sex;
import com.sutticket.sutticketmajor.repository.SexRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SexController {

    @Autowired
    private final SexRepository sexRepository;

    public SexController(SexRepository sexRepository) {
        this.sexRepository = sexRepository;
    }

    @GetMapping("/sex")
    public Collection<Sex> Sex() {
        return sexRepository.findAll().stream().collect(Collectors.toList());
    }

}