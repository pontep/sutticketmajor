package com.okta.spring.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.okta.spring.entity.Customer;
import com.okta.spring.entity.Seat;
import com.okta.spring.entity.ShowSchedule;
import com.okta.spring.entity.TicketBooking;
import com.okta.spring.repository.CustomerRepository;
import com.okta.spring.repository.SeatRepository;
import com.okta.spring.repository.ShowScheduleRepository;
import com.okta.spring.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TicketBookingController {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShowScheduleRepository showScheduleRepository;
    @Autowired
    private SeatRepository seatRepository;

    

    @GetMapping("/ticketBookings")
    public Collection<TicketBooking> getAllTicketBooking() {
        return ticketBookingRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/ticketBooking/{customer_id}/{showschedule_id}/{seat_id}")
    public TicketBooking postTicketBooking(TicketBooking newTicketBooking, @PathVariable long customer_id,
            @PathVariable long showschedule_id, @PathVariable long seat_id ) {
        //สร้าง Object TicketBooking newTicketBooking = new TicketBooking();
        //findById Customer , ShowSchedule , Seat
        Customer customer = customerRepository.findById(customer_id);
        ShowSchedule showschedule = showScheduleRepository.findById(showschedule_id);
        Seat seat = seatRepository.findById(seat_id);
        //set Bookdate , Customer , ShowSchedule , Seat
        newTicketBooking.setBookdate(new Date());
        newTicketBooking.setCustomer(customer);
        newTicketBooking.setShowSchedule(showschedule);
        seat.setIsBook(true); //seat นี้ถูกจองไปแล้ว
        newTicketBooking.setSeat(seat);
        
        
        //save();
        return ticketBookingRepository.save(newTicketBooking);

    }

    @DeleteMapping("/ticketbooking/{id}")
    public ResponseEntity<String> deleteTicketBooking(@PathVariable long id) {
        ticketBookingRepository.deleteById(id);
        return new ResponseEntity<>("Ticketbooking" + id + "has been deleted!", HttpStatus.OK);
    }

}