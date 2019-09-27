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
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

import com.okta.springbootvue.entity.RatingShow;
import com.okta.springbootvue.entity.Show;
import com.okta.springbootvue.entity.TypeShow;
import com.okta.springbootvue.entity.Employee;

import com.okta.springbootvue.repository.RatingShowRepository;
import com.okta.springbootvue.repository.ShowManagementRepository;
import com.okta.springbootvue.repository.TypeShowRepository;
import com.okta.springbootvue.repository.EmployeeRepository;


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
    private EmployeeRepository employeeRepository;


    ShowManagementController(ShowManagementRepository showManagementRepository) {
        this.showManagementRepository= showManagementRepository;
    }

    @GetMapping("/show")
    public Collection<Show> getAllShows() {   //collection ส่งกลับทั้งหมด
        return showManagementRepository.findAll().stream().collect(Collectors.toList()); 
    }

    

    @PostMapping("/show/{employee_id}/{typeShow_id}/{ratingShow_id}")  
    public Show newShow(Show newShow,
    @RequestBody Show show,
    @PathVariable long employee_id,
    @PathVariable long typeShow_id,
    @PathVariable long ratingShow_id)
    
    
     {

     Employee createBy = employeeRepository.findById(employee_id);
     TypeShow type = typeShowRepository.findById(typeShow_id);
     RatingShow rating = ratingShowRepository.findById(ratingShow_id);
    
    newShow.setTitle(show.getTitle());
    newShow.setType(type);   
    newShow.setRating(rating);
    newShow.setCreateBy(createBy);
    return showManagementRepository.save(newShow); //บันทึก Objcet ชื่อ Show

    }
}
