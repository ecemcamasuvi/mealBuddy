package com.moonu.mealbuddy;

import com.moonu.mealbuddy.entity.security.Role;
import com.moonu.mealbuddy.entity.security.User;
import com.moonu.mealbuddy.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MealBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealBuddyApplication.class, args);
		}
	@Bean
	CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
			userService.save(Role.builder().name("ROLE_USER").build());
			userService.save(Role.builder().name("ROLE_ADMIN").build());
			userService.save(User.builder().name("Ecem").username("ecamasuvi").password("1234").build());
			userService.addRoleTo("ecamasuvi","ROLE_USER");
		};
	}

}
