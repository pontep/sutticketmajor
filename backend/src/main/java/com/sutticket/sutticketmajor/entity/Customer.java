package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @SequenceGenerator(name="CUSTOMER_seq",sequenceName="CUSTOMER_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUSTOMER_seq")
    @Column(name = "CUSTOMER_ID", unique = true, nullable = true)
    private  Long id;

    @Column(name="name")
    private  String name;

    @Column(name="username")
    private  String username;

    @Column(name="password")
    private  String password;



    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RangeAge.class)
    @JoinColumn(name = "RANGEAGE_ID", insertable = true)
    private RangeAge rangeage;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Carrer.class)
    @JoinColumn(name = "CARRER_ID", insertable = true)
    private Carrer carrer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sex.class)
    @JoinColumn(name = "SEX_ID", insertable = true)
    private Sex sex;

	public void setRangeAge(RangeAge rangeage) {
        this.rangeage = rangeage;
	}

	public void setCarrer(Carrer carrer) {
        this.carrer = carrer;
    }

	public void setSex(Sex sex) {
        this.sex = sex;
    }
}