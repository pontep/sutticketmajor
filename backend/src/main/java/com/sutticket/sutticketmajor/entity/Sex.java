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
@Table(name="Sex")
public class Sex {
    @Id
    @SequenceGenerator(name="SEX_SEQ",sequenceName="SEX_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEX_SEQ")
    @Column(name="SEX_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String sex;

    @OneToMany(fetch = FetchType.EAGER)
    
    private Collection<Customer> customer;

    public Sex(){}
    public Sex(String sex){
        this.sex=sex;
    }
}