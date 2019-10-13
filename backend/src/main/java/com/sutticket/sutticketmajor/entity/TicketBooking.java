package com.sutticket.sutticketmajor.entity;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "ticketbooking")
public class TicketBooking{
    @Id
    @SequenceGenerator(name="ticketbooking_seq",sequenceName="ticketbooking_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticketbooking_seq")
    @Column(name = "TICKETBOOKING_ID")
    private @NonNull long id;

    @Column(name = "bookDate")
    private @NonNull Date bookDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowSchedule.class)
    @JoinColumn(name = "SHOWSCHEDULE_ID", insertable = true)
    @JsonManagedReference
    private @NonNull ShowSchedule showSchedule;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Seat.class)
    @JoinColumn(name = "SEAT_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Seat seat;

    public TicketBooking(){}
    public TicketBooking(Date date, Customer cus, ShowSchedule ss, Seat seat){
        this.bookDate = date;
        this.customer = cus;
        this.showSchedule = ss;
        this.seat = seat;
    }
}