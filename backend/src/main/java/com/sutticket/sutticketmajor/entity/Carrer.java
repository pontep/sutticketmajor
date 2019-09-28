package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="CARRER")
public class Carrer {
    @Id
    @SequenceGenerator(name="CARRER_SEQ",sequenceName="CARRER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CARRER_SEQ")
    @Column(name="CARRER_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER)
    
    private Collection<Customer> customer;

    public Carrer(){}
    public Carrer(String name){
        this.name=name;
    }
}