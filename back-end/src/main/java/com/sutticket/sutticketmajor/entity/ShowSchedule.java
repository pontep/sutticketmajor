package com.sutticket.sutticketmajor.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Data
@Entity
@Table(name="SHOWSCHEDULE")
public class ShowSchedule {
    @Id
    @SequenceGenerator(name="show_schedule_seq",sequenceName="show_schedule_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="show_schedule_seq")
    @Column(name = "SHOW_SCHEDULE_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="SHOW_DATE")
    private @NonNull Date showDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Show.class)
    @JoinColumn(name = "SHOW_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Show show;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowTime.class)
    @JoinColumn(name = "SHOW_TIME_ID", insertable = true)
    @JsonManagedReference
    private @NonNull ShowTime time;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowLocation.class)
    @JoinColumn(name = "SHOW_LOCATION_ID", insertable = true)
    @JsonManagedReference
    private @NonNull ShowLocation location_at;

    public ShowSchedule(){}
    public ShowSchedule(Date date, Show show, ShowTime time, ShowLocation location){
        this.showDate = date;
        this.show = show;
        this.time = time;
        this.location_at = location;
    }
}