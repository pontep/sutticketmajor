package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Employee;
import com.sutticket.sutticketmajor.entity.PaymentType;
import com.sutticket.sutticketmajor.entity.Receipt;
import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.repository.EmployeeRepository;
import com.sutticket.sutticketmajor.repository.PaymentTypeRepository;
import com.sutticket.sutticketmajor.repository.ReceiptRepository;
import com.sutticket.sutticketmajor.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ReceiptController{

    @Autowired
    private ReceiptRepository receiptrepository;
    @Autowired
    private EmployeeRepository employeerepository;
    @Autowired
    private PaymentTypeRepository paymenttyperepository;
    @Autowired
    private TicketBookingRepository ticketbookingrepository;
    
    @GetMapping("/receipts")
    public Collection<Receipt> getAllReceipt(){
        return receiptrepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/receipt/{ticketbooking_id}")
    public Receipt checkTicket(@PathVariable long ticketbooking_id){
        TicketBooking tmp = ticketbookingrepository.findById(ticketbooking_id);
        return receiptrepository.findByTicketBooking(tmp);
    }

    
    
    @PostMapping("/receipts/{EMPLOYEE_ID}/{PAYMENT_TYPE_ID}/{TICKETBOOKING_ID}")
    public Receipt newReceipt (Receipt newReceipt,
    
    @PathVariable long EMPLOYEE_ID,
    @PathVariable long PAYMENT_TYPE_ID,
    @PathVariable long TICKETBOOKING_ID )
    {
        

        Employee employee = employeerepository.findById(EMPLOYEE_ID);
        TicketBooking ticketBooking = ticketbookingrepository.findById(TICKETBOOKING_ID);
        PaymentType paymentType = paymenttyperepository.findById(PAYMENT_TYPE_ID);
        newReceipt.setReceiptdate(new Date());
        newReceipt.setEmployee(employee);
        newReceipt.setTicketBooking(ticketBooking);
        newReceipt.setPaymentType(paymentType);
        return receiptrepository.save(newReceipt);
    };
}