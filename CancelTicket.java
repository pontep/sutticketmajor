package com.ap.app.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity

public class CancelTicket{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name="CANCEL_DATE")
    private Date cancelDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
    @JoinColumn(name = "TICKETBOOKING_ID", insertable = true)
    private TicketBooking ticketbooking; 

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Reason.class)
    @JoinColumn(name = "REASON_ID", insertable = true)
    private Reason reason;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;

}