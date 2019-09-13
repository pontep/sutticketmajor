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
@Table(name="TYPE_SHOW")
public class TypeShow {
    @Id
    @SequenceGenerator(name="TYPE_SHOW_SEQ",sequenceName="TYPE_SHOW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TYPE_SHOW_SEQ")
    @Column(name="TYPE_SHOW_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String Type;

    @OneToMany(fetch = FetchType.EAGER)

    private Collection<Show> Show;

	
}
