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
@Table(name="TYPESHOW")
public class TypeShow {
    @Id
    @SequenceGenerator(name="TYPESHOW_SEQ",sequenceName="TYPESHOW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TYPESHOW_SEQ")
    @Column(name="TYPESHOW_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String type;

    @OneToMany(fetch = FetchType.EAGER)

    private Collection<Show> Show;

	public TypeShow(){}
}
