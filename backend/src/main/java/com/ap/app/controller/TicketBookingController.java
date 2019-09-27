package com.ap.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.ap.app.entity.TicketBooking;
import com.ap.app.entity.Customer;
import com.ap.app.repository.CustomerRepository;
import com.ap.app.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TicketBookingController{

    @Autowired
    private TicketBookingRepository ticketbookingrepository;
    @Autowired
    private CustomerRepository customerrepository;

    public TicketBookingController(TicketBookingRepository ticketbookingrepository) {
        this.ticketbookingrepository = ticketbookingrepository;
    }

    @GetMapping("/tb")
    public Collection<TicketBooking> getAllTicketBookings(){
        return ticketbookingrepository.findAll().stream().collect(Collectors.toList());
    }
    // @GetMapping("/tb/{customer_id}")
    // public Optional<TicketBooking> getAllTicketBookings(@PathVariable Long customer_id) {
    //     List<TicketBooking> ticketbooking = ticketbookingrepository.findBycustomer_id(customer_id);
    //     return ticketbooking;
    // }

    @GetMapping("tb/customer_id/{customer_id}")
	public List<TicketBooking> findBycustomer_id(@PathVariable Long customer_id) {

		List<TicketBooking> ticketbooking = ticketbookingrepository.findBycustomer_id(customer_id);
		return ticketbooking;
	}
}