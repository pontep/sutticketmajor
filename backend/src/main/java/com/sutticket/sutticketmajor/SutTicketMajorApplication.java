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
			// Bootstrap some test data into the in-memory database
			// Customer
			Customer c1 = new Customer("Pontep Thaweesup", "dinza2541", "96321000");
			Customer c2 = new Customer("Pumarin Peowsongnern", "leo1998", "00000000");
			Customer c3 = new Customer("Jiraporn github", "ple1234", "55554444");
			Stream.of(c1, c2, c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});
			// Seat
			Seat seat[] = new Seat[10];
			for (int i = 0; i < 10; i++) {
				seat[i] = new Seat("A" + (i + 1), 0, false);
				seatRepository.save(seat[i]);
			}
			// Show
			Show show1 = new Show("Note Udom TalkShow 13 at SUT", "โน๊ตอุดม แต้พานิชย์", "Talk show");
			Show show2 = new Show("Bodyslam Live in SUT", "Bodyslam", "คอนเสิร์ต");
			Show show3 = new Show("มทส.แสดท้องคล้องทุ่งนา Season 1", "มหาวิทยาลัยเทคโนโลยีสุรนารี", "ละครเวที");
			Stream.of(show1, show2, show3).forEach(show -> {
				showRepository.save(show); // บันทึก Objcet ชื่อ Customer
			});
			// ShowSchedule
			ShowSchedule ss1 = new ShowSchedule(show1, "เช้า");
			ShowSchedule ss2 = new ShowSchedule(show2, "บ่าย");
			ShowSchedule ss3 = new ShowSchedule(show3, "เย็น");
			Stream.of(ss1, ss2, ss3).forEach(ss -> {
				showScheduleRepository.save(ss); // บันทึก Objcet ชื่อ Customer
			});

			// customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
		};
	}

}
