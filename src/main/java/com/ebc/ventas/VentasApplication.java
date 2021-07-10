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
			repository.save( new User("Julio1", "j1", "test", 123456, Boolean.FALSE));
			repository.save( new User("Julio2", "j2", "test", 123456, Boolean.FALSE));
			repository.save( new User("Julio3", "j3", "test", 123456, Boolean.FALSE));
			repository.save( new User("Julio4", "j4", "test", 123456, Boolean.TRUE));
			repository.save( new User("Julio5", "j5", "test", 123456, Boolean.FALSE));
			repository.save( new User("Julio6", "j6", "test", 123456, Boolean.FALSE));
		};
	}
	
	
}
