package com.okta.spring.entity;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private long id;

    private String username;

    private String password;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

    public Customer(){}
    public Customer(String name, String username , String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
}