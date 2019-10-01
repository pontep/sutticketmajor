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
@Table(name="SHOWTYPE")
public class ShowType {
    @Id
    @SequenceGenerator(name="SHOWTYPE_SEQ",sequenceName="SHOWTYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SHOWTYPE_SEQ")
    @Column(name="SHOWTYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String type;

    @OneToMany(fetch = FetchType.EAGER)

    private Collection<Show> show;

	public ShowType(){}
}
