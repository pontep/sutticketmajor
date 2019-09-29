package com.sutticket.sutticketmajor;

import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.entity.Reason;
import com.sutticket.sutticketmajor.entity.Seat;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.ShowSchedule;
import com.sutticket.sutticketmajor.repository.CancelTicketRepository;
import com.sutticket.sutticketmajor.repository.CustomerRepository;
import com.sutticket.sutticketmajor.repository.TicketBookingRepository;
import com.sutticket.sutticketmajor.repository.ReasonRepository;
import com.sutticket.sutticketmajor.repository.SeatRepository;
import com.sutticket.sutticketmajor.repository.ShowRepository;
import com.sutticket.sutticketmajor.repository.ShowScheduleRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class SutTicketMajorApplication {
	public static void main(String[] args) {
		SpringApplication.run(SutTicketMajorApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, ShowScheduleRepository showscheduleRepository,
			ShowRepository showRepository, SeatRepository seatRepository,TicketBookingRepository ticketbookingRepository,
			ReasonRepository reasonRepository) {
		return args -> {
			
			Customer c1 = new Customer("Black", "dinza2541", "96321000");
			Customer c2 = new Customer("Pink", "leo1998", "00000000");
			Customer c3 = new Customer("Jin", "ple1234", "55554444");
			Stream.of(c1, c2, c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});


			Seat seat[] = new Seat[10];
			for (int i = 0; i < 10; i++) {
				seat[i] = new Seat("A" + (i + 1), 0, false);
				seatRepository.save(seat[i]);
			}

			Show show1 = new Show("Note Udom TalkShow 13 at SUT", "โน๊ตอุดม แต้พานิชย์", "Talk show");
			Show show2 = new Show("Bodyslam Live in SUT", "Bodyslam", "คอนเสิร์ต");
			Show show3 = new Show("มทส.แสดท้องคล้องทุ่งนา Season 1", "มหาวิทยาลัยเทคโนโลยีสุรนารี", "ละครเวที");
			Show show4 = new Show("พี่มาร์ค พระนคร", "มหาวิทยาลัยเทคโนโลยีสุรนารี", "ละครเวที");
			Stream.of(show1, show2, show3, show4).forEach(show -> {
				showRepository.save(show); // บันทึก Objcet ชื่อ Customer
			});

			ShowSchedule ss1 = new ShowSchedule(show1, "เช้า");
			ShowSchedule ss2 = new ShowSchedule(show2, "บ่าย");
			ShowSchedule ss3 = new ShowSchedule(show3, "เย็น");
			ShowSchedule ss4 = new ShowSchedule(show4, "เย็น");
			Stream.of(ss1, ss2, ss3, ss4).forEach(ss -> {
				showscheduleRepository.save(ss); // บันทึก Objcet ชื่อ Customer
			});

			TicketBooking t1 = new TicketBooking(c1, ss1, seat[0]);
			TicketBooking t2 = new TicketBooking(c2, ss2, seat[1]);
			TicketBooking t3 = new TicketBooking(c3, ss3, seat[2]);
			TicketBooking t4 = new TicketBooking(c1, ss4, seat[7]);
			TicketBooking t5 = new TicketBooking(c2, ss3, seat[4]);
			TicketBooking t6 = new TicketBooking(c3, ss1, seat[6]);
			Stream.of(t1, t2, t3, t4, t5, t6).forEach(tb -> {
				ticketbookingRepository.save(tb); // บันทึก Objcet ชื่อ Customer
			});
			Reason r1 = new Reason("ไม่สะดวกในการเข้ารับชม");
			Reason r2 = new Reason("ต้องการเปลี่ยนรอบการแสดงหรือที่นั่ง");
			Reason r3 = new Reason("ต้องการรับชมการแสดงอื่น");
			Reason r4 = new Reason("อื่นๆ");
			Stream.of(r1,r2,r3,r4).forEach(rea -> {
				reasonRepository.save(rea); // บันทึก Objcet ชื่อ Customer
			});

		};
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
			

			// customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			// ticketbookingRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			// reasonRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			
	};
}
