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
@Table(name="SHOW")
public class Show {
    @Id
    @SequenceGenerator(name="show_seq",sequenceName="show_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="show_seq")  
    @Column(name = "SHOW_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String title;

    private @NonNull Long TYPE_ID;
    
    private @NonNull Long RATING_ID;

    private @NonNull Long EMPLOYEE_ID;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<ShowSchedule> schedule;
}