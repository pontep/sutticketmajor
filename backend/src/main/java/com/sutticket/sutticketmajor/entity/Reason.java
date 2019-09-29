package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "reason")
public class Reason{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REASON_ID")
    private long id;

    private String sentence;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = CancelTicket.class)
    private Collection<CancelTicket> cancelticket;

    public Reason(){}
    public Reason(String sentence){
        this.sentence = sentence;
    }
}