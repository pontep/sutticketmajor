package com.ap.app;

import com.ap.app.entity.Customer;
import com.ap.app.entity.TicketBooking;
import com.ap.app.entity.Reason;
import com.ap.app.repository.CancelTicketRepository;
import com.ap.app.repository.CustomerRepository;
import com.ap.app.repository.TicketBookingRepository;
import com.ap.app.repository.ReasonRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class appApplication {
@Autowired
private CancelTicketRepository cancelticketRepository;
@Autowired
private CustomerRepository  customerRepository;
@Autowired
private TicketBookingRepository ticketBookingRepository;
@Autowired
private ReasonRepository reasonRepository;

	public static void main(String[] args) {
		SpringApplication.run(appApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, TicketBookingRepository ticketbookingRepository, ReasonRepository reasonRepository) {
		return args -> {
			
			Customer c1 = new Customer("Pontep Thaweesup","dinza2541","96321000");
			Customer c2 = new Customer("Pumarin Peowsongnern","leo1998","00000000");
			Customer c3 = new Customer("Chirapon Worasuk","ple1234","55554444");
			Stream.of(c1,c2,c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});

			TicketBooking t1 = new TicketBooking("20190923","dinza2541","A1","มทส.แสดท้องคล้องทุ่งนา Season 1");
			TicketBooking t2 = new TicketBooking("20190926","leo1998","A5","โน๊ตอุดม แต้พานิชย์");
			TicketBooking t3 = new TicketBooking("20190921","ple1234","A9","Bodyslam");
			Stream.of(t1,t2,t3).forEach(tick -> {
				ticketbookingRepository.save(tick); // บันทึก Objcet ชื่อ Customer
			});

			Reason r1 = new Reason("ไม่สะดวกในการเข้ารับชม");
			Reason r2 = new Reason("ต้องการเปลี่ยนรอบการแสดงหรือที่นั่ง");
			Reason r3 = new Reason("ต้องการรับชมการแสดงอื่น");
			Reason r4 = new Reason("อื่นๆ");
			Stream.of(r1,r2,r3,r4).forEach(rea -> {
				reasonRepository.save(rea); // บันทึก Objcet ชื่อ Customer
			});

			// Stream.of("aa", "bb", "cc", "dd").forEach(name -> {
			// 	TicketBooking ticketbooking = new TicketBooking(); // สร้าง Object TicketBooking
			// 	ticketbooking.setSHOWSCHEDULE_id(name); // set ชื่อ (name) ให้ Object ชื่อ ticketbooking
			// 	ticketbookingRepository.save(ticketbooking); // บันทึก Objcet ชื่อ ticketbooking
			// });

			// Stream.of("ไม่สะดวกในการเข้ารับชมการแสดง", "ต้องการเปลี่ยนรอบหรือที่นั่ง", "ต้องการรับชมการแสดงอื่น","อื่นๆ").forEach(name -> {
			// 	Reason reason = new Reason(); // สร้าง Object Customer
			// 	reason.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
			// 	reasonRepository.save(reason); // บันทึก Objcet ชื่อ Customer
			// });
			

			customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			ticketbookingRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			reasonRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			
		};
	}

}
