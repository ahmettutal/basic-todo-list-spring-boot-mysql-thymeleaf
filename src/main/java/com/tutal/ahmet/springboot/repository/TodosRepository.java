package com.tutal.ahmet.springboot.repository;

import com.tutal.ahmet.springboot.entity.Todos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodosRepository extends CrudRepository<Todos, Long> {

    Todos findByName(String name);

    List<Todos> findByComplatedAndUserId(boolean complated, Long Id);

}
