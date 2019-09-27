// package com.ap.app.entity;

// import java.sql.Date;
// import java.util.Collection;
// import javax.persistence.*;
// import lombok.Data;
// import com.fasterxml.jackson.annotation.JsonIgnore;

// @Data
// @Entity
// @Table(name = "TICKETBOOKING")
// public class TicketBooking{

//     @Id    
//     @Column(name = "TICKETBOOKING_ID")
//     private long id;

//     private String BookDate;
//     private String Customer_id;
//     private String SEAT_id;
//     private String SHOWSCHEDULE_id;
    
    
//     @OneToOne(fetch = FetchType.EAGER, targetEntity = TicketBooking.class)
//     private Collection<CancelTicket> cancelticket; 

//     public void setTicketBooking(String name){
//         this.SHOWSCHEDULE_id = name;
//     }
//     public TicketBooking(){}
// }

package com.ap.app.entity;

import java.util.Collection;

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

    private String BookDate;
    private String Customer_id;
    private String SEAT_id;
    private String SHOW_id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = CancelTicket.class)
    private Collection<CancelTicket> cancelticket;

    public TicketBooking(){}
    public TicketBooking(String BookDate, String Customer_id , String SEAT_id, String SHOW_id){
        this.BookDate = BookDate;
        this.Customer_id = Customer_id;
        this.SEAT_id = SEAT_id;
        this.SHOW_id = SHOW_id;
    }
}