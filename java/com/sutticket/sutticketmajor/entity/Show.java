package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "show")
public class Show{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOW_ID")
    private long id;

    private String name;
    private String organizer;
    private String show_type;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}