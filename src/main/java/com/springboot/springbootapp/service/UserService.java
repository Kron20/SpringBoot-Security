package com.springboot.springbootapp.service;

import com.springboot.springbootapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User showById(Long id);

    User update(User user);

    void addUser(User user);

    void delete(Long id);

    List<User> getAllUsers();
}
