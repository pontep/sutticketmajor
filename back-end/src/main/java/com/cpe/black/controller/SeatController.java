// package com.cpe.black.controller;

// import java.util.Collection;
// import java.util.stream.Collectors;

// import com.cpe.black.entity.Seat;
// import com.cpe.black.repository.SeatRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:8080")
// @RestController
// @RequestMapping("/api")
// public class SeatController {

//     @Autowired
//     private final SeatRepository seatRepository;

//     public SeatController(SeatRepository seatRepository) {
//         this.seatRepository = seatRepository;
//     }

//     @GetMapping("/seats")
//     public Collection<Seat> setSeats() {
//         return seatRepository.findAll().stream().collect(Collectors.toList());
//     }
// }