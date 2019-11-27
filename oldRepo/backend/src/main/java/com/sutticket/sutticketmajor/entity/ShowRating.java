package com.sutticket.sutticketmajor.entity;

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
@Table(name="SHOWRATING")
public class ShowRating {
    @Id
    @SequenceGenerator(name="SHOWRATING_SEQ",sequenceName="SHOWRATING_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SHOWRATING_SEQ")
    @Column(name="SHOWRATING_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String rate;

    // @OneToMany(fetch = FetchType.EAGER)
    // private Collection<Show> show;
    
    public ShowRating(){}
    public ShowRating(String rate){
        this.rate = rate;
    }
	
}
