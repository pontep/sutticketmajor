package com.okta.spring.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.okta.spring.entity.Contact;
import com.okta.spring.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ContactController{
    @Autowired
    ContactRepository repository;
    
   
    @GetMapping("/r")
    public Collection<Contact> getAllReceipt(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
}