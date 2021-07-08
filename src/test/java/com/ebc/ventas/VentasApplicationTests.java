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
	private User userDeleted;

	@BeforeEach
	void setUp() {

		user = new User();
		user.setUsername("foobar");
		user.setPassword("123456");

		userDeleted = new User();
		userDeleted.setUsername("lencho");
		userDeleted.setPassword("12345678");
		userDeleted.setDeleted(Boolean.TRUE);
	}

	@Test
	void findSavedUserById() {

		user = repository.save(user);

		assertThat(repository.findById(user.getId())).hasValue(user);
	}

	@Test
	void findSavedUserByLastnameAndPassword() {

		user = repository.save(user);
		
		assertThat(repository.findByUsernameAndPassword("foobar", "123456")).isSameAs(user);
	}

	void findSavedUserByLastnameAndPasswordAndNotDeleted() {
		userDeleted = repository.save(userDeleted);

		assertThat(repository.findByUsernameAndPasswordAndNotDeleted("lencho", "12345678")).isNull();
	}

}