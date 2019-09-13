package com.ap.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reason{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sentence;

}