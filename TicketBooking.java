package com.ap.app.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TicketBooking{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String show;
    private String performance;
    private String member;
    private String seat;
    private Date bookdate;
}