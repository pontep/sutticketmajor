package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "showschedule")
public class ShowSchedule{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOWSCHEDULE_ID")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Show.class)
    @JoinColumn(name = "show_id", insertable = true)
    @JsonManagedReference
    private Show show;
    
    private String schedule; //เช้าสายบ่ายเย็น
    
    public ShowSchedule(){}
    
    public ShowSchedule(Show show, String schedule){
        this.show = show;
        this.schedule = schedule;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}