package com.sutticket.sutticketmajor;

import com.sutticket.sutticketmajor.entity.ShowRating;
import com.sutticket.sutticketmajor.entity.ShowType;
import com.sutticket.sutticketmajor.entity.Employee;

import com.sutticket.sutticketmajor.repository.ShowRatingRepository;
import com.sutticket.sutticketmajor.repository.ShowTypeRepository;
import com.sutticket.sutticketmajor.repository.EmployeeRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class ShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowApplication.class, args);
	}
	@Bean
	ApplicationRunner init(EmployeeRepository employeeRepository, ShowTypeRepository showtypeRepository, ShowRatingRepository ShowratingRepository) {
		return args -> {
			Employee em1 = new Employee("Patcharaphon","1234","newphoto123");
			Employee em2 = new Employee("Pontep","1150","Dincraker123");
			Employee em3 = new Employee("New","5678","van123");
			Stream.of(em1,em2,em3).forEach(employee_name ->{
				employeeRepository.save(employee_name);
			});
			
			Stream.of("ตลก","ละคร", "Coverdance", "ย้อนยุค", "ประวัติศาสตร์","Action").forEach(Type -> {
				ShowType typeShow = new ShowType(); // ????? Object Employee
				typeShow.setType(Type); // set ???? (name) ??? Object ???? Employee
				showtypeRepository.save(typeShow); // ?????? Objcet ???? Employee
			});

		
			Stream.of("ทุกเพศทุกวัย","18+", "15+","12+").forEach(Rate -> {
				ShowRating ratingShow = new ShowRating(); // ????? Object Video
				ratingShow.setRate(Rate); // set ???? (name) ??? Object ???? Video
				ShowratingRepository.save(ratingShow); // ?????? Objcet ???? Video
			});

			employeeRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity Employee ?? Terminal
			showtypeRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity RentalType ?? Terminal
			ShowratingRepository.findAll().forEach(System.out::println); // ???? ??????????????? Entity Video ?? Terminal
		};
	}



}
