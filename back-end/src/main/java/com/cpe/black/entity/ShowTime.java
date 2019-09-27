package com.cpe.black.entity;

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
@NoArgsConstructor
@Table(name="SHOWTIME")
public class ShowTime {
    @Id
    @SequenceGenerator(name="show_time_seq",sequenceName="show_time_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="show_time_seq")  
    @Column(name = "SHOW_TIME_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String part;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<ShowSchedule> schedule;
}