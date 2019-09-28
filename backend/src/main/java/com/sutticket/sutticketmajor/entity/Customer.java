package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer{
    
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
    @Column(name = "CUSTOMER_ID")
    private long id;

    private String username;

    private String password;

    private String name;

    public Customer(){}
    public Customer(String name, String username , String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
}