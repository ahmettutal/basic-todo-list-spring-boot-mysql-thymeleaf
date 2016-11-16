package com.tutal.ahmet.springboot.service;

import com.tutal.ahmet.springboot.entity.Todos;
import org.springframework.ui.Model;

public interface TodosService {

    void addTodos(String name);

    Todos findByName(String name);

    void updateComplated(String name);

    void deleteTodos(String name);

    void findByCompletedAndUserId(Model model);
}
