package com.sutticket.sutticketmajor;

import java.sql.Date;
import java.util.stream.Stream;

import com.sutticket.sutticketmajor.entity.CancelTicket;
import com.sutticket.sutticketmajor.entity.Carrer;
import com.sutticket.sutticketmajor.entity.Customer;
import com.sutticket.sutticketmajor.entity.Employee;
import com.sutticket.sutticketmajor.entity.PaymentType;
import com.sutticket.sutticketmajor.entity.RangeAge;
import com.sutticket.sutticketmajor.entity.Reason;
import com.sutticket.sutticketmajor.entity.Receipt;
import com.sutticket.sutticketmajor.entity.Seat;
import com.sutticket.sutticketmajor.entity.Sex;
import com.sutticket.sutticketmajor.entity.Show;
import com.sutticket.sutticketmajor.entity.ShowLocation;
import com.sutticket.sutticketmajor.entity.ShowRating;
import com.sutticket.sutticketmajor.entity.ShowSchedule;
import com.sutticket.sutticketmajor.entity.ShowTime;
import com.sutticket.sutticketmajor.entity.ShowType;
import com.sutticket.sutticketmajor.entity.TicketBooking;
import com.sutticket.sutticketmajor.repository.CancelTicketRepository;
import com.sutticket.sutticketmajor.repository.CarrerRepository;
import com.sutticket.sutticketmajor.repository.CustomerRepository;
import com.sutticket.sutticketmajor.repository.EmployeeRepository;
import com.sutticket.sutticketmajor.repository.PaymentTypeRepository;
import com.sutticket.sutticketmajor.repository.RangeAgeRepository;
import com.sutticket.sutticketmajor.repository.ReasonRepository;
import com.sutticket.sutticketmajor.repository.ReceiptRepository;
import com.sutticket.sutticketmajor.repository.SeatRepository;
import com.sutticket.sutticketmajor.repository.SexRepository;
import com.sutticket.sutticketmajor.repository.ShowLocationRepository;
import com.sutticket.sutticketmajor.repository.ShowRatingRepository;
import com.sutticket.sutticketmajor.repository.ShowRepository;
import com.sutticket.sutticketmajor.repository.ShowScheduleRepository;
import com.sutticket.sutticketmajor.repository.ShowTimeRepository;
import com.sutticket.sutticketmajor.repository.ShowTypeRepository;
import com.sutticket.sutticketmajor.repository.TicketBookingRepository;

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
	ApplicationRunner init(CancelTicketRepository cancelTicketRepository,ReceiptRepository receiptRepository,
		TicketBookingRepository ticketBookingRepository,
		ReasonRepository reasonRepository,
		ShowTimeRepository showTimeRepository, ShowLocationRepository showLocationRepository,
		ShowRatingRepository showRatingRepository,ShowTypeRepository showTypeRepository,
		EmployeeRepository employeeRepository, PaymentTypeRepository paymentTypeRepository, CarrerRepository carrerRepository, RangeAgeRepository rangeAgeRepository, SexRepository sexRepository, ShowRepository showRepository, CustomerRepository customerRepository,
			SeatRepository seatRepository, ShowScheduleRepository showScheduleRepository) {
		return args -> {
			// Bootstrap some test data into the in-memory database
			// Employee
			Employee emp1 = new Employee("Nutthawut S.", "nutts", "12345678");
			Employee emp2 = new Employee("Phatcharaphon Thaicharoen", "newza", "00000000");
			Employee emp3 = new Employee("Pakorn Harnnirojrum", "somtuy", "55555555");
			Stream.of(emp1, emp2, emp3).forEach(emp -> {
				employeeRepository.save(emp); // บันทึก Objcet ชื่อ Customer
			});
			// Customer
			Sex sex1 = new Sex("ชาย");
			Sex sex2 = new Sex("หญิง");
			Stream.of(sex1,sex2).forEach(sex -> {
				sexRepository.save(sex); 
			});

			RangeAge ra1 = new RangeAge("13-18");
			RangeAge ra2 = new RangeAge("19-25");
			RangeAge ra3 = new RangeAge("25-30");
			RangeAge ra4 = new RangeAge("31-36");
			Stream.of(ra1,ra2,ra3,ra4).forEach(range -> {
				rangeAgeRepository.save(range); 
			});

			Carrer cr1 = new Carrer("นักศึกษา");
			Carrer cr2 = new Carrer("พนักงานออฟฟิศ");
			Carrer cr3 = new Carrer("อาจารย์");
			Stream.of(cr1,cr2,cr3).forEach(carrer -> {
				carrerRepository.save(carrer); 
			});

			Customer c1 = new Customer("Pontep Thaweesup", "dinza2541", "96321000",ra2,cr1,sex1);
			Customer c2 = new Customer("Pumarin Peowsongnern", "leo1998", "00000000",ra3,cr2,sex1);
			Customer c3 = new Customer("Chiraphon Worasuk", "ple1234", "55554444",ra1,cr3,sex2);
			Stream.of(c1, c2, c3).forEach(cus -> {
				customerRepository.save(cus); // บันทึก Objcet ชื่อ Customer
			});
			// Seat
			Seat seat[] = new Seat[10];
			for (int i = 0; i < 10; i++) {
				seat[i] = new Seat("A" + (i + 1), 0, false);
				seatRepository.save(seat[i]);
			}
			// ShowManagement - New
			ShowType showType1 = new ShowType("คอนเสิร์ท");
			ShowType showType2 = new ShowType("ละครเวที");
			ShowType showType3 = new ShowType("TalkShow");
			Stream.of(showType1,showType2,showType3).forEach(showType -> {
				showTypeRepository.save(showType);
			});
			ShowRating showRating1 = new ShowRating("ทุกเพศทุกวัย");
			ShowRating showRating2 = new ShowRating("สำหรับผู้ที่มีอายุ 18 ปีขึ้นไป");
			ShowRating showRating3 = new ShowRating("สำหรับผู้ที่มีอายุ 15 ปีขึ้นไป");
			Stream.of(showRating1,showRating2,showRating3).forEach(showRating -> {
				showRatingRepository.save(showRating); 
			});

			
			Show show1 = new Show("Note Udom TalkShow 13 at SUT",emp1,showType3,showRating2);
			Show show2 = new Show("Bodyslam Live in SUT",emp2,showType1,showRating3);
			Show show3 = new Show("มทส.แสดท้องคล้องทุ่งนา Season 1",emp3,showType2,showRating1);
			Stream.of(show1, show2, show3).forEach(show -> {
				showRepository.save(show);
			});
			// ShowSchedule
			ShowTime showTime1 = new ShowTime("08.00-11.00 น.");
			ShowTime showTime2 = new ShowTime("13.00-16.00 น.");
			ShowTime showTime3 = new ShowTime("18.00-21.00 น.");
			Stream.of(showTime1,showTime2,showTime3).forEach(showTime -> {
				showTimeRepository.save(showTime);
			});
			ShowLocation showLocation1 = new ShowLocation("ห้องวิทยานิพนธ์(1500)");
			ShowLocation showLocation2 = new ShowLocation("ห้อง 600");
			ShowLocation showLocation3 = new ShowLocation("ลานหมอลำ");
			Stream.of(showLocation1,showLocation2,showLocation3).forEach(location -> {
				showLocationRepository.save(location);
			});
			//YYYY-MM-DD
			Date date1 = Date.valueOf("2019-10-07");
			Date date2 = Date.valueOf("2019-10-08");
			Date date3 = Date.valueOf("2019-10-09");
			//date show showtime showlo
			ShowSchedule ss1 = new ShowSchedule(date1,show1,showTime1,showLocation1);
			ShowSchedule ss2 = new ShowSchedule(date2,show2,showTime2,showLocation2);
			ShowSchedule ss3 = new ShowSchedule(date3,show3,showTime3,showLocation3);
			Stream.of(ss1, ss2, ss3).forEach(ss -> {
				showScheduleRepository.save(ss);
			});
			//tb1,2 for cancel , 3,4 for receipt 
			TicketBooking tb1 = new TicketBooking(new java.util.Date(),c1,ss1,seat[0] );
			TicketBooking tb2 = new TicketBooking(new java.util.Date(),c2,ss2,seat[1] );
			TicketBooking tb3 = new TicketBooking(new java.util.Date(),c3,ss1,seat[2] );
			TicketBooking tb4 = new TicketBooking(new java.util.Date(),c1,ss2,seat[3] );
			Stream.of(tb1,tb2,tb3,tb4).forEach(tb -> {
				ticketBookingRepository.save(tb);
			});
			//Receipt-LEO
			PaymentType paymentType1 = new PaymentType("Kbank");
			PaymentType paymentType2 = new PaymentType("Credit Card");
			PaymentType paymentType3 = new PaymentType("Airpay");
			PaymentType paymentType4 = new PaymentType("ชำระด้วยเงินสด");
			Stream.of(paymentType1,paymentType2,paymentType3,paymentType4).forEach(paymentType -> {
				paymentTypeRepository.save(paymentType);
			});
			//CancelTicket-Ple
			Reason r1 = new Reason("ไม่สะดวกในการเข้ารับชม");
			Reason r2 = new Reason("ต้องการเปลี่ยนรอบการแสดงหรือที่นั่ง");
			Reason r3 = new Reason("ต้องการรับชมการแสดงอื่น");
			Reason r4 = new Reason("อื่นๆ");
			Stream.of(r1,r2,r3,r4).forEach(rea -> {
				reasonRepository.save(rea); 
			});
			CancelTicket cancelTicket1 = new CancelTicket(c1,tb1,r1);
			CancelTicket cancelTicket2 = new CancelTicket(c2,tb2,r4);
			Stream.of(cancelTicket1,cancelTicket2).forEach(ct -> {
				cancelTicketRepository.save(ct);
			});

			Receipt receipt1 = new Receipt(tb3,paymentType4,emp1);
			Receipt receipt2 = new Receipt(tb4,paymentType2,emp2);
			Stream.of(receipt1,receipt2).forEach(receipt -> {
				receiptRepository.save(receipt);
			});
			//customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
		};
	}

}
