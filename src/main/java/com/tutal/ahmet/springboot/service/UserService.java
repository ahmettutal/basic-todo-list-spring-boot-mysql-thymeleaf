package com.tutal.ahmet.springboot.service;


import com.tutal.ahmet.springboot.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
