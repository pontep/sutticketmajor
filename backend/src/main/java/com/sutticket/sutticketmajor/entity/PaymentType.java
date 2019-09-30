package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class PaymentType{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PaymentType_ID")
    private long id;    
    private String payment;

    

    public PaymentType(){}
}