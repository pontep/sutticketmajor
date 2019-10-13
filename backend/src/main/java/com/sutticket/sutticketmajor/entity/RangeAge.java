package com.sutticket.sutticketmajor.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name="RANGEAGE")
public class RangeAge {
	@Id
	@SequenceGenerator(name="RANGEAGE_seq",sequenceName="RANGEAGE_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RANGEAGE_seq")
	@Column(name="RANGEAGE_ID",unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String rangeages;

	public RangeAge(){}
    public RangeAge(String rangeages){
        this.rangeages=rangeages;
    }
}
