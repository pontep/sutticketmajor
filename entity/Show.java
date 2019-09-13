package com.okta.springbootvue.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@Entity
@Table(name="Show")
public class Show {

    @Id
    @SequenceGenerator(name="Show_seq",sequenceName="Show_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SHOW_seq")
    @Column(name = "Show_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="TITLE")
    private @NonNull String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RatingShow.class)
    @JoinColumn(name = "RATING_SHOW_ID", insertable = true)
    private RatingShow rating;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeShow.class)
    @JoinColumn(name = "TYPE_SHOW_ID", insertable = true)
    private TypeShow type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =  ShowLength.class)
    @JoinColumn(name = "ShowLength_ID", insertable = true)
    private ShowLength length;

	
}
