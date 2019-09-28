package com.sutticket.sutticketmajor.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_ID",insertable = true)
    private long id;

    private String name;
    private String user;
    private String pass; 

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receipt.class)
    // @JoinColumn(name = "RECEIPT_ID", insertable = true)
    // @JsonManagedReference
	// private @NotNull Receipt receipt;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receipt.class)
    // @JoinColumn(name = "RECEIPT_ID", insertable = true)
    // private Receipt receipt;
     public Employee(){}
     public Employee(String name,String  user,String pass){
         this.name =name;
         this.pass=pass;
         this.user=user;

     }
}
