package com.okta.spring.controller;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.okta.spring.entity.*;
import com.okta.spring.repository.EmployeeRepository;
import com.okta.spring.repository.PaymentTypeRepository;
import com.okta.spring.repository.ReceiptRepository;
import com.okta.spring.repository.TicketBookingRepository;
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