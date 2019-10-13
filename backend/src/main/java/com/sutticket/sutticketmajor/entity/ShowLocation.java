package com.sutticket.sutticketmajor.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name="SHOWLOCATION")
public class ShowLocation {
    @Id
    @SequenceGenerator(name="show_location_seq",sequenceName="show_location_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="show_location_seq")  
    @Column(name = "SHOW_LOCATION_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String location;

    public ShowLocation(){}
    public ShowLocation(String location){
        this.location = location;
    }
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<ShowSchedule> schedule;
}