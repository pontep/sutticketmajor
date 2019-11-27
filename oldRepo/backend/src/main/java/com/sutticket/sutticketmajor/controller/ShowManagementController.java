package com.sutticket.sutticketmajor.controller;

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

import com.sutticket.sutticketmajor.entity.ShowRating;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.ShowType;
import com.sutticket.sutticketmajor.entity.Employee;

import com.sutticket.sutticketmajor.repository.ShowRatingRepository;
import com.sutticket.sutticketmajor.repository.ShowManagementRepository;
import com.sutticket.sutticketmajor.repository.ShowTypeRepository;
import com.sutticket.sutticketmajor.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShowManagementController {
    @Autowired
    private final ShowManagementRepository showManagementRepository;
    @Autowired
    private ShowRatingRepository showRatingRepository;
    @Autowired
    private ShowTypeRepository showTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    ShowManagementController(ShowManagementRepository showManagementRepository) {
        this.showManagementRepository= showManagementRepository;
    }

    @GetMapping("/Shows")
    public Collection<Show> getAllShows() {   //collection ส่งกลับทั้งหมด
        return showManagementRepository.findAll().stream().collect(Collectors.toList()); 
    }

    
    //ส่งค่าแบบ RequestBody ของ show(พกของติดตัวมา title)
    @PostMapping("/show/{employee_id}/{ShowType_id}/{ShowRating_id}")  
    public Show newShow(Show newShow,
    @RequestBody Show show,
    @PathVariable long employee_id,
    @PathVariable long ShowType_id,
    @PathVariable long ShowRating_id)
    
    
     {

     Employee createBy = employeeRepository.findById(employee_id);
     ShowType type = showTypeRepository.findById(ShowType_id);
     ShowRating rating = showRatingRepository.findById(ShowRating_id);
    
    newShow.setTitle(show.getTitle());
    newShow.setType(type);   
    newShow.setRating(rating);
    newShow.setCreateBy(createBy);
    return showManagementRepository.save(newShow); //บันทึก Objcet ชื่อ Show

    }

    //ส่งค่าแบบ PathVariable ของ title ใน show
    @PostMapping("/show2/{employee_id}/{ShowType_id}/{ShowRating_id}/{title}")  
    public Show newShow2(Show newShow,
    @PathVariable String title,
    @PathVariable long employee_id,
    @PathVariable long ShowType_id,
    @PathVariable long ShowRating_id)
    
    
     {

     Employee createBy = employeeRepository.findById(employee_id);
     ShowType type = showTypeRepository.findById(ShowType_id);
     ShowRating rating = showRatingRepository.findById(ShowRating_id);
    
    newShow.setTitle(title);
    newShow.setType(type);   
    newShow.setRating(rating);
    newShow.setCreateBy(createBy);
    return showManagementRepository.save(newShow); //บันทึก Objcet ชื่อ Show

    }
}
