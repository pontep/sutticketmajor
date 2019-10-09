package com.sutticket.sutticketmajor.controller;

import com.sutticket.sutticketmajor.entity.Career;
import com.sutticket.sutticketmajor.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CareerController {

    @Autowired
    private final CareerRepository careerRepository;

    public CareerController(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @GetMapping("/career")
    public Collection<Career> Career() {
        return careerRepository.findAll().stream().collect(Collectors.toList());
    }

}

 /* @GetMapping("/name")
    public String getFronk(){
        return "pakorn hannirojram";
    }

    @PostMapping("/car/{name}")
    public String posta(@PathVariable String name){
        Carrer carrer = new Carrer();
        carrer.setName(name);
        carrerRepository.save(carrer);
        return "เสร็จแล้ว";
    }*/