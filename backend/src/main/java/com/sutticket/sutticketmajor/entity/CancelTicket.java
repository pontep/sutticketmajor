package com.sutticket.sutticketmajor.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "cancelticket")
public class CancelTicket{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="CANCEL_DATE")
    private Date cancelDate;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    @JoinColumn(name = "TICKETBOOKING_ID", insertable = true)
    private TicketBooking ticketBooking; 

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Reason.class)
    @JoinColumn(name = "REASON_ID", insertable = true)
    private Reason reason;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer customer;
    

    public CancelTicket(){}
    public CancelTicket(Customer customer, TicketBooking ticketbooking,  Reason reason){
        this.cancelDate = new Date();
        this.customer = customer;
        this.ticketBooking = ticketbooking;
        this.reason = reason;
        

    }

}