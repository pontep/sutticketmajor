package com.okta.spring;

import java.sql.Date;
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
			Stream.of(e1, e2, e3).forEach(emp -> {
				employeerepository.save(emp); // บันทึก Objcet ชื่อ Customer
			});

			Customer c1 = new Customer("Black", "dinza2541", "96321000");
			Customer c2 = new Customer("Pink", "leo1998", "00000000");
			Customer c3 = new Customer("Jin", "ple1234", "55554444");
			Stream.of(c1, c2, c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("Kbank", "Credit Card", "Airpay", "ชำระด้วยเงินสด").forEach(name -> {
				PaymentType paymentType = new PaymentType(); // สร้าง Object Customer
				paymentType.setPayment(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				paymenttyperepository.save(paymentType); // บันทึก Objcet ชื่อ Customer
			});

			Seat seat[] = new Seat[10];
			for (int i = 0; i < 10; i++) {
				seat[i] = new Seat("A" + (i + 1), 0, false);
				seatRepository.save(seat[i]);
			}

			Show show1 = new Show("Note Udom TalkShow 13 at SUT", "โน๊ตอุดม แต้พานิชย์", "Talk show");
			Show show2 = new Show("Bodyslam Live in SUT", "Bodyslam", "คอนเสิร์ต");
			Show show3 = new Show("มทส.แสดท้องคล้องทุ่งนา Season 1", "มหาวิทยาลัยเทคโนโลยีสุรนารี", "ละครเวที");
			Stream.of(show1, show2, show3).forEach(show -> {
				showRepository.save(show); // บันทึก Objcet ชื่อ Customer
			});

			ShowSchedule ss1 = new ShowSchedule(show1, "เช้า");
			ShowSchedule ss2 = new ShowSchedule(show2, "บ่าย");
			ShowSchedule ss3 = new ShowSchedule(show3, "เย็น");
			Stream.of(ss1, ss2, ss3).forEach(ss -> {
				showscheduleRepository.save(ss); // บันทึก Objcet ชื่อ Customer
			});

			
			TicketBooking t1 = new TicketBooking(c1, ss1,seat[0]);
			TicketBooking t2 = new TicketBooking(c2, ss2,seat[1]);
			TicketBooking t3 = new TicketBooking(c3, ss3,seat[2]);
			Stream.of(t1, t2, t3).forEach(tb -> {
				ticketbookingrepository.save(tb); // บันทึก Objcet ชื่อ Customer
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
