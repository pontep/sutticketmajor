package com.cpe.black.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.cpe.black.entity.*;
import com.cpe.black.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowScheduleController {
    
    @Autowired
    private final ShowScheduleRepository showScheduleRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowTimeRepository showTimeRepository;
    @Autowired
    private ShowLocationRepository showLocationRepository;

    ShowScheduleController(ShowScheduleRepository showScheduleRepository) {
        this.showScheduleRepository = showScheduleRepository;
    }

    @GetMapping("/showSchedules")
    public Collection<ShowSchedule> VideoRentals() {
        return showScheduleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/showSchedule/{show_id}/{showtime_id}/{showlocation_id}")
    public ShowSchedule newShowSchedule(ShowSchedule newShowSchedule, @RequestBody ShowSchedule showdate,
    @PathVariable long show_id,
    @PathVariable long showtime_id,
    @PathVariable long showlocation_id) {
        
        Show showname = showRepository.findById(show_id);
        ShowTime time = showTimeRepository.findById(showtime_id);
        ShowLocation location_at = showLocationRepository.findById(showlocation_id);
        
        newShowSchedule.setShowname(showname);
        newShowSchedule.setTime(time);
        newShowSchedule.setLocation_at(location_at);
        newShowSchedule.setShowDate(showdate.getShowDate());
        return showScheduleRepository.save(newShowSchedule);
    }
}