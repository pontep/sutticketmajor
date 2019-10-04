package com.sutticket.sutticketmajor.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.Seat;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.ShowSchedule;
import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.repository.CustomerRepository;
import com.sutticket.sutticketmajor.repository.SeatRepository;
import com.sutticket.sutticketmajor.repository.ShowRepository;
import com.sutticket.sutticketmajor.repository.ShowScheduleRepository;
import com.sutticket.sutticketmajor.repository.TicketBookingRepository;

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

    @GetMapping("/ticketbooking/{customer_id}")
    public List<TicketBooking> getTicketBookingWhereCustomer(@PathVariable long customer_id){
        Customer cus = customerRepository.findById(customer_id);
        List<TicketBooking> ticketBookings = ticketBookingRepository.findByCustomer(cus);
        return ticketBookings;
    }

    @PostMapping("/ticketBooking/{customer_id}/{showschedule_id}/{seat_id}")
    public TicketBooking postTicketBooking(TicketBooking newTicketBooking, @PathVariable long customer_id,
            @PathVariable long showschedule_id, @PathVariable long seat_id ) {
        Customer customer = customerRepository.findById(customer_id);
        ShowSchedule showschedule = showScheduleRepository.findById(showschedule_id);
        Seat seat = seatRepository.findById(seat_id);
        
        newTicketBooking.setBookdate(new Date());
        newTicketBooking.setCustomer(customer);
        newTicketBooking.setShowSchedule(showschedule);
        seat.setIsBook(true); //seat นี้ถูกจองไปแล้ว
        newTicketBooking.setSeat(seat);
        return ticketBookingRepository.save(newTicketBooking);

    }

    @DeleteMapping("/ticketbooking/{id}")
    public ResponseEntity<String> deleteTicketBooking(@PathVariable long id) {
        ticketBookingRepository.deleteById(id);
        return new ResponseEntity<>("Ticketbooking" + id + "has been deleted!", HttpStatus.OK);
    }

}