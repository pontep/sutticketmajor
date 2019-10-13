package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class PaymentType{

    @Id
    @SequenceGenerator(name="paymentType_seq",sequenceName="paymentType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paymentType_seq")
    @Column(name = "PaymentType_ID")
    private @NonNull long id;    
    
    private @NonNull String payment;
    
    public PaymentType(){}
    public PaymentType(String payment){
        this.payment = payment;
    }
}