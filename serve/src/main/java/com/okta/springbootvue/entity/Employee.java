package com.okta.springbootvue.entity;

import javax.persistence.*;
import java.util.Collection;


import lombok.Data;
import lombok.NonNull;
@Entity
@Data
@Table(name ="EMPLOYEE")
public class Employee{
    @Id
    @SequenceGenerator(name="EMPLOYEE_SEQ",sequenceName="EMPLOYEE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
    @Column(name="EMPLOYEE_ID",unique = true, nullable = true)

    private @NonNull Long id;

    private @NonNull String employee_username;

    private @NonNull  String employee_password;
 
    private @NonNull  String employee_name;

    private @NonNull  String employee_sex;

    @OneToMany(fetch = FetchType.EAGER)

    private Collection<Show> Show;

    public Employee(){}

    public Employee(String employee_name,String employee_password,String employee_sex,String employee_username){
        this.employee_name=employee_name;
        this.employee_password=employee_password;
        this.employee_sex=employee_sex;
        this.employee_username=employee_username;
    }

}