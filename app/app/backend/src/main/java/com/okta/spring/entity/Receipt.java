package com.okta.spring.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
@Data
@Entity
public class Receipt
 {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECEIPT_ID", unique = true, nullable = true,insertable = true)    
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketBooking")
    @JsonManagedReference
	private TicketBooking ticketBooking;    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentType.class)
    @JoinColumn(name = "PaymentType_ID", insertable = true)
    @JsonManagedReference
    private PaymentType paymentType;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)    
    @JsonManagedReference
	private  Employee employee;
    private Date receiptdate;
    public Receipt(){   
        this.receiptdate = new Date();      
    } 
}
