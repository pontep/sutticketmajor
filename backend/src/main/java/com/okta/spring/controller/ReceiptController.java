package com.okta.spring.controller;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.okta.spring.entity.Receipt;
import com.okta.spring.repository.ReceiptRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ReceiptController{

    @Autowired
    ReceiptRepository repository;
    
    @GetMapping("/receipts")
    public Collection<Receipt> getAllReceipt(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

}