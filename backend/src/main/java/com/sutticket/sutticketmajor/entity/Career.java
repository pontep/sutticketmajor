package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name="CAREER")
public class Career {
    @Id
    @SequenceGenerator(name="CAREER_SEQ",sequenceName="CAREER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CAREER_SEQ")
    @Column(name="CAREER_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    public Career(){}
    public Career(String name){
        this.name=name;
    }
}