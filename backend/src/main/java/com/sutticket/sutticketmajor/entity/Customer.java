package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @SequenceGenerator(name="CUSTOMER_seq",sequenceName="CUSTOMER_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUSTOMER_seq")
    @Column(name = "CUSTOMER_ID", unique = true, nullable = true)
    private  Long id;

    @Column(name="name")
    private  String name;

    @Column(name="username")
    private  String username;

    @Column(name="password")
    private  String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RangeAge.class)
    @JoinColumn(name = "RANGEAGE_ID", insertable = true)
    @JsonManagedReference
    private RangeAge rangeAge;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Carrer.class)
    @JoinColumn(name = "CARRER_ID", insertable = true)
    @JsonManagedReference
    private Carrer carrer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sex.class)
    @JoinColumn(name = "SEX_ID", insertable = true)
    @JsonManagedReference
    private Sex sex;

    public Customer(){}
    public Customer(String name, String username, String pass, RangeAge rangeAge, Carrer carrer, Sex sex){
        this.name = name;
        this.username = username;
        this.password = pass;
        this.rangeAge = rangeAge;
        this.carrer = carrer;
        this.sex = sex;
    }
}