package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "reason")
public class Reason{
    
    @Id
    @SequenceGenerator(name="reason_seq",sequenceName="reason_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reason_seq")
    @Column(name = "REASON_ID")
    private @NonNull long id;

    private @NonNull String sentence;

    // @OneToMany(fetch = FetchType.EAGER, targetEntity = CancelTicket.class)
    // private Collection<CancelTicket> cancelticket;

    public Reason(){}
    public Reason(String sentence){
        this.sentence = sentence;
    }
}