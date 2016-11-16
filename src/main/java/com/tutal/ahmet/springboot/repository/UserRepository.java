package com.tutal.ahmet.springboot.repository;

import com.tutal.ahmet.springboot.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
