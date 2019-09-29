package com.ap.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.ap.app.entity.ShowSchedule;
import com.ap.app.repository.ShowScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ShowScheduleController{

    @Autowired
    ShowScheduleRepository showscheduleRepository;
    
    @GetMapping("/ShowSchedules")
    public Collection<ShowSchedule> getAllShowSchedule(){
        return showscheduleRepository.findAll().stream().collect(Collectors.toList());
    }

}