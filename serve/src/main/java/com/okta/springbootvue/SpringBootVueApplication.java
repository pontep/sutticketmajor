package com.okta.springbootvue;

import com.okta.springbootvue.entity.RatingShow;
import com.okta.springbootvue.entity.TypeShow;
import com.okta.springbootvue.entity.Employee;

import com.okta.springbootvue.repository.RatingShowRepository;
import com.okta.springbootvue.repository.TypeShowRepository;
import com.okta.springbootvue.repository.EmployeeRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
//
@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}
	@Bean
	ApplicationRunner init(EmployeeRepository employeeRepository, TypeShowRepository typeshowRepository, RatingShowRepository ratingShowRepository) {
		return args -> {
			Stream.of("Patcharaphon", "Phosaphunk", "Somchai", "Mr.new").forEach(employee_name -> {
				Employee employee = new Employee(); // ????? Object Customer
				employee.setEmployee_name(employee_name);								// set ???? (name) ??? Object ???? Customer
				employeeRepository.save(employee); // ?????? Objcet ???? Customer
			});



			Stream.of("ละคร", "Coverdance", "ย้อนยุค", "ประวัติศาสตร์").forEach(Type -> {
				TypeShow typeShow = new TypeShow(); // ????? Object Employee
				typeShow.setType(Type); // set ???? (name) ??? Object ???? Employee
				typeshowRepository.save(typeShow); // ?????? Objcet ???? Employee
			});

		
			Stream.of("18+", "15+").forEach(Rate -> {
				RatingShow ratingShow = new RatingShow(); // ????? Object Video
				ratingShow.setRate(Rate); // set ???? (name) ??? Object ???? Video
				ratingShowRepository.save(ratingShow); // ?????? Objcet ???? Video
			});

			employeeRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity Employee ?? Terminal
			typeshowRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity RentalType ?? Terminal
			ratingShowRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity Video ?? Terminal
		};
	}



}
