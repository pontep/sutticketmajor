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

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}