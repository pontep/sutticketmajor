package com.okta.spring.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "ticketbooking")
public class TicketBooking{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TICKETBOOKING_ID")
    private long id;

    @Column(name = "bookDate")
    private Date bookdate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer customer;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Show.class)
    // @JoinColumn(name = "SHOW_ID", insertable = true)
    // private Show show;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowSchedule.class)
    @JoinColumn(name = "SHOWSCHEDULE_ID", insertable = true)
    private ShowSchedule showSchedule;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Seat.class)
    @JoinColumn(name = "SEAT_ID", insertable = true)
    private Seat seat;
    
    public TicketBooking(){}
    public TicketBooking(Customer customer , ShowSchedule showSchedule ,Seat seat){
        this.bookdate = new Date();
        this.customer = customer;
        this.seat = seat;
        this.showSchedule = showSchedule;
    }

}