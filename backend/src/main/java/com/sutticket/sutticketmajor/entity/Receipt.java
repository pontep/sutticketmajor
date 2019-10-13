package com.sutticket.sutticketmajor.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "receipt")
public class Receipt
 {    
    
    @Id
    @SequenceGenerator(name="receipt_seq",sequenceName="receipt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="receipt_seq")
    @Column(name = "RECEIPT_ID", unique = true, nullable = true,insertable = true)    
    private long id;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "ticketBooking")
    // @JsonManagedReference
    // private TicketBooking ticketBooking;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    @JoinColumn(name = "TICKETBOOKING_ID", insertable = true)
    @JsonManagedReference
    private TicketBooking ticketBooking; 

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentType.class)
    @JoinColumn(name = "PaymentType_ID", insertable = true)
    @JsonManagedReference
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    @JsonManagedReference
	private  Employee employee;

    private Date receiptdate;

    public Receipt(){}
    public Receipt(TicketBooking tb, PaymentType pt, Employee emp){
        this.ticketBooking = tb;
        this.paymentType = pt;
        this.employee = emp;
        this.receiptdate = new Date();
    }
}
