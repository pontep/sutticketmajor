package com.okta.springbootvue.entity;

import lombok.Data;
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
import lombok.NonNull;
@Data
@Entity
@Table(name="RATINGSHOW")
public class RatingShow {
    @Id
    @SequenceGenerator(name="RATINGSHOW_SEQ",sequenceName="RATINGSHOW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RATINGSHOW_SEQ")
    @Column(name="RATINGSHOW_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String rate;

    @OneToMany(fetch = FetchType.EAGER)
 
    private Collection<Show> Show;
    
    public RatingShow(){}
	
}
