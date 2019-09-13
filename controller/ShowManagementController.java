package com.okta.springbootvue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

import com.okta.springbootvue.entity.RatingShow;
import com.okta.springbootvue.entity.Show;
import com.okta.springbootvue.entity.TypeShow;
import com.okta.springbootvue.entity.ShowLength;

import com.okta.springbootvue.repository.RatingShowRepository;
import com.okta.springbootvue.repository.ShowManagementRepository;
import com.okta.springbootvue.repository.TypeShowRepository;
import com.okta.springbootvue.repository.ShowLengthRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowManagementController {
    @Autowired
    private final ShowManagementRepository showManagementRepository;
    @Autowired
    private RatingShowRepository ratingShowRepository;
    @Autowired
    private TypeShowRepository typeShowRepository;
    @Autowired
    private ShowLengthRepository showLengthRepository;


    ShowManagementController(ShowManagementRepository showManagementRepository) {
        this.showManagementRepository= showManagementRepository;
    }

    @GetMapping("/show")
    public Collection<Show> getAllShow() {   //collection ส่งกลับทั้งหมด
        return showManagementRepository.findAll().stream().collect(Collectors.toList()); 
    }


    @PostMapping("/show/{typeShow_id}/{ratingShow_id}/{showLength_id}")  
    public Show newShow(Show newShow, 
    @PathVariable long typeShow_id,
    @PathVariable long ratingShow_id,
    @PathVariable long showLength_id)
    
     {

     ShowLength length = showLengthRepository.findById(showLength_id);
     TypeShow type = typeShowRepository.findById(typeShow_id);
     RatingShow rating = ratingShowRepository.findById(ratingShow_id);
   
    newShow.setTitle(new String());
    newShow.setType(type);   
    newShow.setRating(rating);
    newShow.setLength(length);
    

    return showManagementRepository.save(newShow); //บันทึก Objcet ชื่อ Show

    }
}
