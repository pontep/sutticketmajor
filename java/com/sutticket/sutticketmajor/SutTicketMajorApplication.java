package com.sutticket.sutticketmajor;

import java.util.stream.Stream;

import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.Seat;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.ShowSchedule;
import com.sutticket.sutticketmajor.repository.CustomerRepository;
import com.sutticket.sutticketmajor.repository.SeatRepository;
import com.sutticket.sutticketmajor.repository.ShowRepository;
import com.sutticket.sutticketmajor.repository.ShowScheduleRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SutTicketMajorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SutTicketMajorApplication.class, args);
	}

	// @Bean
	// ApplicationRunner init(ShowRepository showRepository, CustomerRepository customerRepository,SeatRepository seatRepository,ShowScheduleRepository showScheduleRepository) {
	// 	return args -> {
	// 		Stream.of("Takoonkan", "Sitthichai", "Somchai", "Tanapon").forEach(name -> {
	// 			Customer customer = new Customer(); // สร้าง Object Customer
	// 			customer.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
	// 			customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer
	// 		});
	// 		Stream.of("A1", "A2", "A3", "A4").forEach(name -> {
	// 			Seat seat = new Seat(); // สร้าง Object Customer
	// 			seat.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
	// 			seatRepository.save(seat); // บันทึก Objcet ชื่อ Customer
	// 		});
	// 		Stream.of("Note Udom TalkShow 12",
	// 		 "Bodyslam Live in SUT",
	// 		  "SUT Dancing girls", 
	// 		  "Sompordee SUT Band Show2019").forEach(name -> {
	// 			Show show = new Show(); // สร้าง Object Customer
	// 			show.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
	// 			showRepository.save(show); // บันทึก Objcet ชื่อ Customer
	// 		});
	// 		Stream.of("เช้า", "สาย", "บ่าย", "เย็น").forEach(name -> {
	// 			ShowSchedule schedule = new ShowSchedule(); // สร้าง Object Customer
	// 			schedule.setSchedule(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
	// 			showScheduleRepository.save(schedule); // บันทึก Objcet ชื่อ Customer
	// 		});
			
	// 		customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
	// 	};
	// }


}
