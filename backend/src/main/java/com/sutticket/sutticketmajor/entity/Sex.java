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
@Table(name="Sex")
public class Sex {
    @Id
    @SequenceGenerator(name="SEX_SEQ",sequenceName="SEX_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEX_SEQ")
    @Column(name="SEX_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String sex;

    public Sex(){}
    public Sex(String sex){
        this.sex=sex;
    }
}