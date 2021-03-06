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
    private @NonNull Long id;

    @Column(name="name")
    private @NonNull String name;

    @Column(name="username")
    private @NonNull String username;

    @Column(name="password")
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RangeAge.class)
    @JoinColumn(name = "RANGEAGE_ID", insertable = true)
    @JsonManagedReference
    private @NonNull RangeAge rangeAge;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Career.class)
    @JoinColumn(name = "CAREER_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Career career;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sex.class)
    @JoinColumn(name = "SEX_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Sex sex;

    public Customer(){}
    public Customer(String name, String username, String pass, RangeAge rangeAge, Career career, Sex sex){
        this.name = name;
        this.username = username;
        this.password = pass;
        this.rangeAge = rangeAge;
        this.career = career;
        this.sex = sex;
    }
}