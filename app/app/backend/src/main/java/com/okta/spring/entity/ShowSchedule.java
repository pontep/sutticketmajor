package com.okta.spring.entity;
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
    @JoinColumn(name = "show", insertable = true)
    @JsonManagedReference
    private Show show;
    
    private String schedule; //เช้าสายบ่ายเย็น

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    private Collection<TicketBooking> ticketBooking;

}