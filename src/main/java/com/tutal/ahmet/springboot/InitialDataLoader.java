package com.tutal.ahmet.springboot;

import com.tutal.ahmet.springboot.entity.AppContact;
import com.tutal.ahmet.springboot.entity.AppRole;
import com.tutal.ahmet.springboot.entity.AppUser;
import com.tutal.ahmet.springboot.repository.ContactRepository;
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
    private ContactRepository contactRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        AppContact readContact = createContactIfNotFound("READ_CONTACT");
        AppContact writeContact = createContactIfNotFound("WRITE_CONTACT");
        List<AppContact> adminContacts = Arrays.asList(readContact, writeContact);
        createRoleIfNotFound("ROLE_ADMIN", adminContacts);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readContact));

        AppRole adminRole = roleRepository.findByRolename("ROLE_ADMIN");
        AppUser user = new AppUser();
        user.setFirstName("test");
        user.setLastName("test");
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRoles(Arrays.asList(adminRole));

        AppUser user2 = userRepository.findByUsername("test");
        if (user2 == null)
            userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private AppContact createContactIfNotFound(String name) {
        AppContact contact = contactRepository.findByName(name);
        if (contact == null) {
            contact = new AppContact(name);
            contactRepository.save(contact);
        }
        return contact;
    }

    @Transactional
    private AppRole createRoleIfNotFound(String name, List<AppContact> contacts) {
        AppRole role = roleRepository.findByRolename(name);
        if (role == null) {
            role = new AppRole(name);
            role.setContacts(contacts);
            roleRepository.save(role);
        }
        return role;
    }
}