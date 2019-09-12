package com.okta.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Complacency{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sentence;

}