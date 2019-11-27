package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@Entity
@Table(name="SHOW")
public class Show {

    @Id
    @SequenceGenerator(name="SHOW_seq",sequenceName="SHOW_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SHOW_seq")
    @Column(name = "SHOW_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="TITLE")
    private @NonNull String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =  Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private @NonNull Employee createBy;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowType.class)
    @JoinColumn(name = "SHOWTYPE_ID", insertable = true)
    @JsonManagedReference
    private @NonNull ShowType type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShowRating.class)
    @JoinColumn(name = "SHOWRATING_ID", insertable = true)
    @JsonManagedReference
    private @NonNull ShowRating rating;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<ShowSchedule> schedule;
    public Show(){}

    public Show(String title, Employee emp, ShowType st, ShowRating sr ){
        this.title = title;
        this.createBy = emp;
        this.type = st;
        this.rating = sr;
    }
    
    

	
}
