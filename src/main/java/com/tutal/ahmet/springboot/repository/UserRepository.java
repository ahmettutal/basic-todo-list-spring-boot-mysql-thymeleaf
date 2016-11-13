package com.tutal.ahmet.springboot.repository;

import com.tutal.ahmet.springboot.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
