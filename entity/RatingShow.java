package com.okta.springbootvue.entity;

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
@Table(name="RATING_SHOW")
public class RatingShow {
    @Id
    @SequenceGenerator(name="RATING_SHOW_SEQ",sequenceName="RATING_SHOW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RATING_SHOW_SEQ")
    @Column(name="RATING_SHOW_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String Rate;

    @OneToMany(fetch = FetchType.EAGER)
 
    private Collection<Show> Show;

	
}
