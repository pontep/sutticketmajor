package com.france.france;

import java.util.stream.Stream;

import com.france.france.entity.Carrer;
import com.france.france.entity.RangeAge;
import com.france.france.entity.Sex;
import com.france.france.repository.Carrerrepository;
import com.france.france.repository.RangeAgerepository;
import com.france.france.repository.Sexrepository;

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
	ApplicationRunner init(Sexrepository sexrepository, RangeAgerepository rangeagerepository, Carrerrepository carrerrepository) {
		return args -> {
			
			Sex s1 = new Sex("ชาย");
			Sex s2 = new Sex("หญิง");
			Stream.of(s1,s2).forEach(sex -> {
				sexrepository.save(sex); // บันทึก Objcet ชื่อ Customer
			});

			RangeAge r1 = new RangeAge("13-18");
			RangeAge r2 = new RangeAge("19-25");
			RangeAge r3 = new RangeAge("25-30");
			RangeAge r4 = new RangeAge("31-36");
			Stream.of(r1,r2,r3,r4).forEach(range -> {
				rangeagerepository.save(range); // บันทึก Objcet ชื่อ Customer
			});

			Carrer c1 = new Carrer("นักศึกษา");
			Carrer c2 = new Carrer("พนักงานออฟฟิศ");
			Carrer c3 = new Carrer("อาจาร์ย");
			Stream.of(c1,c2,c3).forEach(carrer -> {
				carrerrepository.save(carrer); // บันทึก Objcet ชื่อ Customer
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
			

			sexrepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			rangeagerepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			carrerrepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
			
		};
	}
}


