package com.tutal.ahmet.springboot;

import com.tutal.ahmet.springboot.entity.Role;
import com.tutal.ahmet.springboot.entity.User;
import com.tutal.ahmet.springboot.repository.RoleRepository;
import com.tutal.ahmet.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_USER");

        Role adminRole = roleRepository.findByRolename("ROLE_ADMIN");
        Role userRole = roleRepository.findByRolename("ROLE_USER");

        User user = new User();
        user.setFirstName("Admin1");
        user.setLastName("Last1");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Arrays.asList(adminRole, userRole));

        User user2 = userRepository.findByUsername("admin");
        if (user2 == null)
            userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByRolename(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}