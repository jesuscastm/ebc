package com.ebc.ventas;

import static org.assertj.core.api.Assertions.*;

import com.ebc.ventas.entity.User;
import com.ebc.ventas.entity.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VentasApplicationTests {

	@Autowired UserRepository repository;
	private User user;

	@BeforeEach
	void setUp() {

		user = new User();
		user.setUsername("foobar");
		user.setPassword("123456");
	}

	@Test
	void findSavedUserById() {

		user = repository.save(user);

		assertThat(repository.findById(user.getId())).hasValue(user);
	}

	@Test
	void findSavedUserByLastnam() {

		user = repository.save(user);
		
		assertThat(repository.findByUsernameAndPassword("foobar", "123456")).isSameAs(user);
	}

}