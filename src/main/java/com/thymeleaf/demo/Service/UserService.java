package com.thymeleaf.demo.Service;

import com.thymeleaf.demo.Model.User;

public interface UserService {

    public User findByEmail(String email);
    public void saveUser(User user);
}
