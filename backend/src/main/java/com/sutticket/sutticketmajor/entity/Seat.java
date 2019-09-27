package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "seat")
public class Seat{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEAT_ID")
    private long id;

    private String name;

    private long seat_level = 0;

    private Boolean isBook = false;

    public Seat(){}
    public Seat(String name , long level, Boolean isBook){
        this.name = name;
        this.seat_level = level;
        this.isBook = isBook;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}