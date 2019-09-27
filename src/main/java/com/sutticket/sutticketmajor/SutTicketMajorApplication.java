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

	@Bean
	ApplicationRunner init(ShowRepository showRepository, CustomerRepository customerRepository,
			SeatRepository seatRepository, ShowScheduleRepository showScheduleRepository) {
		return args -> {
			//Fake data
			//Customer
			Customer c1 = new Customer("Pontep Thaweesup","dinza2541","96321000");
			Customer c2 = new Customer("Pumarin Peowsongnern","leo1998","00000000");
			Customer c3 = new Customer("Jiraporn github","ple1234","55554444");
			Stream.of(c1,c2,c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});
			//Seat
			Seat seat[] = new Seat[10];
			for(int i = 0; i < 10 ; i++){
				seat[i] = new Seat("A"+(i+1),0,false);
				seatRepository.save(seat[i]);
			}
			
			Stream.of("Note Udom TalkShow 12", "Bodyslam Live in SUT", "SUT Dancing girls",
					"Sompordee SUT Band Show2019").forEach(name -> {
						Show show = new Show(); // สร้าง Object Customer
						show.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
						showRepository.save(show); // บันทึก Objcet ชื่อ Customer
					});
			Stream.of("เช้า", "สาย", "บ่าย", "เย็น").forEach(name -> {
				ShowSchedule schedule = new ShowSchedule(); // สร้าง Object Customer
				schedule.setSchedule(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				showScheduleRepository.save(schedule); // บันทึก Objcet ชื่อ Customer
			});

			customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน
																		// Terminal
		};
	}

}
