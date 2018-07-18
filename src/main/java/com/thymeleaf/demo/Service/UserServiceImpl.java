package com.thymeleaf.demo.Service;

import com.thymeleaf.demo.Model.Role;
import com.thymeleaf.demo.Model.User;
import com.thymeleaf.demo.Repositories.RoleRepository;
import com.thymeleaf.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;

@Autowired
private RoleRepository roleRepository;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

    }
}
