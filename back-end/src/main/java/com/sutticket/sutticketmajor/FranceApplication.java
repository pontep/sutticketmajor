package com.sutticket.sutticketmajor;

import java.util.stream.Stream;

import com.sutticket.sutticketmajor.entity.Career;
import com.sutticket.sutticketmajor.entity.RangeAge;
import com.sutticket.sutticketmajor.entity.Sex;
import com.sutticket.sutticketmajor.repository.CareerRepository;
import com.sutticket.sutticketmajor.repository.RangeAgeRepository;
import com.sutticket.sutticketmajor.repository.SexRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranceApplication.class, args);
	}
	@Bean
	ApplicationRunner init(SexRepository sexRepository, RangeAgeRepository rangeageRepository, CareerRepository careerRepository) {
		return args -> {
			
			Sex sex1 = new Sex("ชาย");
			Sex sex2 = new Sex("หญิง");
			Sex sex3 = new Sex("เพศที่ 3");
			Stream.of(sex1,sex2,sex3).forEach(sex -> {
				sexRepository.save(sex); // บันทึก Objcet ชื่อ Customer
			});

			RangeAge rangeage1 = new RangeAge("13-18");
			RangeAge rangeage2 = new RangeAge("19-25");
			RangeAge rangeage3 = new RangeAge("25-30");
			RangeAge rangeage4 = new RangeAge("31-36");
			Stream.of(rangeage1,rangeage2,rangeage3,rangeage4).forEach(range -> {
				rangeageRepository.save(range); // บันทึก Objcet ชื่อ Customer
			});

			Career career1 = new Career("นักศึกษา");
			Career career2 = new Career("พนักงานออฟฟิศ");
			Career career3 = new Career("อาจาร์ย");
			Stream.of(career1,career2,career3).forEach(career -> {
				careerRepository.save(career); // บันทึก Objcet ชื่อ Customer
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
			

			sexRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			rangeageRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			careerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			
		};
	}
}


