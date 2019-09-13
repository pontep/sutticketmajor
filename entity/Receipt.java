package com.okta.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Receipt
 {    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECEIPT_ID", unique = true, nullable = true)
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    @JoinColumn(name = "TICKETBOOKING_ID", insertable = true)
    private TicketBooking ticketBooking;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", insertable = true)
    private Contact contact;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Complacency.class)
    @JoinColumn(name = "COMPLACENCY_ID", insertable = true)
    private Complacency complacency;

        
}
