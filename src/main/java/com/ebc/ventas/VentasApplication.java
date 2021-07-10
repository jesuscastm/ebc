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
			repository.save( new User("Jose Pérez", "jose.p", "-test1", 1, Boolean.FALSE));
			repository.save( new User("Victor López", "victor.l", "-test2", 44, Boolean.FALSE));
			repository.save( new User("Pedro Martínez", "pedro.m", "-test3", 2, Boolean.FALSE));
			repository.save( new User("Victoria Martínez", "victoria.m", "-test4", 0, Boolean.TRUE));
			repository.save( new User("Olga Pérez", "olga.p", "-test4", 4, Boolean.FALSE));
			repository.save( new User("Karina Mendoza", "karina.m", "@test5", 1, Boolean.FALSE));
		};
	}
	
	
}
