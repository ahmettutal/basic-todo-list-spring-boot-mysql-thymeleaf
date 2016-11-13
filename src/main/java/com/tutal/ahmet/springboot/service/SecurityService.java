package com.tutal.ahmet.springboot.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
