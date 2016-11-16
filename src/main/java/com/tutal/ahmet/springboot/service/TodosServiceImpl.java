package com.tutal.ahmet.springboot.service;

import com.tutal.ahmet.springboot.entity.Todos;
import com.tutal.ahmet.springboot.entity.User;
import com.tutal.ahmet.springboot.repository.TodosRepository;
import com.tutal.ahmet.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("todosService")
public class TodosServiceImpl implements TodosService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TodosRepository todosRepository;

    @Override
    public void addTodos(String name) {

        Todos todos = new Todos(name, false);

        todos.setUser(getCurrentUser());
        todosRepository.save(todos);
    }

    @Override
    public Todos findByName(String name) {
        return todosRepository.findByName(name);
    }

    @Override
    public void updateComplated(String name) {

        Todos todos = findByName(name);

        todos.setCompleted(true);

        todosRepository.save(todos);
    }

    @Override
    public void deleteTodos(String name) {

        Todos todos = findByName(name);

        todosRepository.delete(todos);
    }

    @Override
    public void findByCompletedAndUserId(Model model) {

        User currentUser = getCurrentUser();

        model.addAttribute("todosList", todosRepository.findByCompletedAndUserId(false, currentUser.getId()));

        model.addAttribute("todosDoneList", todosRepository.findByCompletedAndUserId(true, currentUser.getId()));

        model.addAttribute("username", currentUser.getUsername());
    }

    public User getCurrentUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return userRepository.findByUsername(auth.getName());
    }

}
