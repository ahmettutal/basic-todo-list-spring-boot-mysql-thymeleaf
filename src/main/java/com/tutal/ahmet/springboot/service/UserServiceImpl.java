package com.tutal.ahmet.springboot.service;

import com.tutal.ahmet.springboot.entity.User;
import com.tutal.ahmet.springboot.repository.RoleRepository;
import com.tutal.ahmet.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles(roleRepository.findAll());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
