package com.sutticket.sutticketmajor.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "cancelticket")
public class CancelTicket{
    @Id
    @SequenceGenerator(name="calcelTicket_seq",sequenceName="calcelTicket_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calcelTicket_seq")
    @Column(name = "CANCELTICKET_ID", unique = true, nullable = true,insertable = true)
    private long id;

    @Column(name="CANCEL_DATE")
    private Date cancelDate;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    @JoinColumn(name = "TICKETBOOKING_ID", insertable = true)
    @JsonManagedReference
    private TicketBooking ticketBooking; 

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Reason.class)
    @JoinColumn(name = "REASON_ID", insertable = true)
    @JsonManagedReference
    private Reason reason;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    @JsonManagedReference
    private Customer customer;
    

    public CancelTicket(){}
    public CancelTicket(Customer customer, TicketBooking ticketbooking,  Reason reason){
        this.cancelDate = new Date();
        this.customer = customer;
        this.ticketBooking = ticketbooking;
        this.reason = reason;
        

    }

}