package com.okta.spring.entity;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "show")
public class Show{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOW_ID")
    private long id;

    private String name;
    private String organizer;
    private String show_type;

    public Show(){}
    public Show(String name, String org, String st){
        this.name = name;
        this.organizer = org;
        this.show_type = st;
    }

}