package com.cpe.black;

import java.util.stream.Stream;

import com.cpe.black.entity.*;
import com.cpe.black.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShowScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowScheduleApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ShowRepository showRepository, ShowTimeRepository 
	showTimeRepository, ShowLocationRepository showLocationRepository, SeatRepository seatRepository) {
		return args -> {
			Stream.of("FOO", "DOOMILK", "DOMTIA", "SOTORN", "PANOM").forEach(title -> {
				Show show = new Show(); // สร้าง Object Customer
				show.setTitle(title); // set ชื่อ (name) ให้ Object ชื่อ Customer
				showRepository.save(show); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of(100, 300, 500, 1000).forEach(seat -> {
				Seat seatShow = new Seat(); // สร้าง Object Customer
				seatShow.setSeat(seat); // set ชื่อ (name) ให้ Object ชื่อ Customer
				seatRepository.save(seatShow); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("08.00-11.00 น.", "13.00-16.00 น.", "18.00-21.00 น.").forEach(part -> {
				ShowTime showTime = new ShowTime(); // สร้าง Object Customer
				showTime.setPart(part); // set ชื่อ (name) ให้ Object ชื่อ Customer
				showTimeRepository.save(showTime); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("BUILDING I", "THE MALL", "CENTRAL", "SAVEONE").forEach(location -> {
				ShowLocation showLocation = new ShowLocation(); // สร้าง Object Customer
				showLocation.setLocation(location); // set ชื่อ (name) ให้ Object ชื่อ Customer
				showLocationRepository.save(showLocation); // บันทึก Objcet ชื่อ Customer
			});

			showRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			showTimeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			showLocationRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
		};
	}
}
