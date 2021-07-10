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
	private User userFound;
	private User userDeleted;

	@BeforeEach
	void setUp() {

		user = new User();
		user.setUsername("foobar");
		user.setPassword("123456");
		user.setDeleted(Boolean.FALSE);

		userFound = new User();
		userFound.setUsername("foo");
		userFound.setPassword("123456");
		userFound.setDeleted(Boolean.FALSE);

		userDeleted = new User();
		userDeleted.setUsername("lencho");
		userDeleted.setPassword("12345678");
		userDeleted.setDeleted(Boolean.TRUE);
	}

	@Test
	void findSavedUserById() {

		user = repository.save(user);

		assertThat(repository.findById(user.getId())).contains(user);
	}

	@Test
	void findSavedUserByLastnameAndPassword() {
		userFound = repository.save(userFound);
		
		assertThat(repository.findByUsernameAndPassword("foo", "123456")).isEqualTo(user);
	}

	@Test
	void findSavedUserByLastnameAndPasswordAndNotDeleted() {
		userDeleted = repository.save(userDeleted);

		assertThat(repository.findByUsernameAndPasswordAndDeleted("lencho", "12345678", Boolean.FALSE)).isNull();
	}

}