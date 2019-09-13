package com.okta.springbootvue.controller;

import com.okta.springbootvue.entity.ShowLength;
import com.okta.springbootvue.repository.ShowLengthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ShowLengthController {

    @Autowired
    ShowLengthRepository showLengthRepository;

    

    @GetMapping("/showlength")
    public Collection<ShowLength> getAllShowLengths() {
        return showLengthRepository.findAll().stream().collect(Collectors.toList());
    }



}
