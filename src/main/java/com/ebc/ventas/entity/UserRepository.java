package com.ebc.ventas.entity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsernameAndPasswordAndNotDeleted(String username, String password);
}
