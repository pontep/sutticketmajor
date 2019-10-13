package com.sutticket.sutticketmajor.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "seat")
public class Seat{
    
    @Id
    @SequenceGenerator(name="seat_seq",sequenceName="seat_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seat_seq")
    @Column(name = "SEAT_ID")
    private @NonNull long id;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowSchedule.class)
    // @JoinColumn(name = "SHOW_SCHEDULE_ID", insertable = true)
    // @JsonManagedReference
    // private @NonNull ShowSchedule showSchedule;

    private @NonNull String name;
    // private @NonNull long seat_level = 0;
    // private @NonNull Boolean isBook = false;

    public Seat(){}
    public Seat(String name){
        this.name = name;
        // this.seat_level = level;
        // this.isBook = isBook;
    };

}