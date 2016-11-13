package com.tutal.ahmet.springboot.service;


import com.tutal.ahmet.springboot.entity.AppUser;

public interface UserService {

    void save(AppUser user);

    AppUser findByUsername(String username);

}
