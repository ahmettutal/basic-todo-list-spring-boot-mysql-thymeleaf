package com.tutal.ahmet.springboot.repository;

import com.tutal.ahmet.springboot.entity.AppContact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<AppContact, Long> {

    AppContact findByName(String name);

}
