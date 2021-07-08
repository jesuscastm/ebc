package com.ebc.ventas;

import org.slf4j.LoggerFactory;

import com.ebc.ventas.entity.User;
import com.ebc.ventas.entity.UserRepository;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VentasApplication {

	private static final Logger log =
	LoggerFactory.getLogger(VentasApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
			repository.save( new User("Julio", "j", "test", 1, Boolean.FALSE));
		};
	}
	
	
}
