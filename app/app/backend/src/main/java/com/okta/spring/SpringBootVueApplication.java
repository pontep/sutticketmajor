package com.okta.spring;

import java.util.stream.Stream;

import com.okta.spring.entity.Customer;
import com.okta.spring.entity.Employee;
import com.okta.spring.entity.PaymentType;
import com.okta.spring.entity.Seat;
import com.okta.spring.entity.Show;
import com.okta.spring.entity.ShowSchedule;
import com.okta.spring.entity.TicketBooking;
import com.okta.spring.repository.CustomerRepository;
import com.okta.spring.repository.EmployeeRepository;
import com.okta.spring.repository.PaymentTypeRepository;
import com.okta.spring.repository.ReceiptRepository;
import com.okta.spring.repository.SeatRepository;
import com.okta.spring.repository.ShowRepository;
import com.okta.spring.repository.ShowScheduleRepository;
import com.okta.spring.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, ShowScheduleRepository showscheduleRepository,
			ShowRepository showRepository, SeatRepository seatRepository, EmployeeRepository employeerepository,
			PaymentTypeRepository paymenttyperepository, TicketBookingRepository ticketbookingrepository) {
		return args -> {
			Employee e1 = new Employee("Pontep Thaweesup", "dinza2541", "96321000");
			Employee e2 = new Employee("Pumarin Peowsongnern", "leo1998", "00000000");
			Employee e3 = new Employee("Jiraporn github", "ple1234", "55554444");
			Stream.of(e1, e2, e3).forEach(cus -> {
				employeerepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});

			Customer c1 = new Customer("Black", "dinza2541", "96321000");
			Customer c2 = new Customer("Pink", "leo1998", "00000000");
			Customer c3 = new Customer("Jin", "ple1234", "55554444");
			Stream.of(c1, c2, c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("Kbank", "Credit Card", "Airpay").forEach(name -> {
				PaymentType paymentType = new PaymentType(); // สร้าง Object Customer
				paymentType.setPayment(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				paymenttyperepository.save(paymentType); // บันทึก Objcet ชื่อ Customer
			});

			Seat seat[] = new Seat[10];
			for (int i = 0; i < 10; i++) {
				seat[i] = new Seat("A" + (i + 1), 0, false);
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
				showscheduleRepository.save(schedule); // บันทึก Objcet ชื่อ Customer
			});

		};

		// customerRepository.findAll().forEach(System.out::println); // แสดง
		// ข้อมูลทั้งหมดใน Entity Customer บน
		// // Terminal
		// employeerepository.findAll().forEach(System.out::println); // แสดง
		// ข้อมูลทั้งหมดใน Entity Customer บน Terminal
		// ticketbookingrepository.findAll().forEach(System.out::println); // แสดง
		// ข้อมูลทั้งหมดใน Entity Employee บน Terminal
		// paymenttyperepository.findAll().forEach(System.out::println); // แสดง
		// ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
		// videoRepository.findAll().forEach(System.out::println); // แสดง
		// ข้อมูลทั้งหมดใน Entity Video บน Terminal
	};
}
