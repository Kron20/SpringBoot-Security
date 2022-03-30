package com.springboot.springbootapp.service;

import com.springboot.springbootapp.model.User;
import com.springboot.springbootapp.repository.UserRepo;
import com.springboot.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User showById(Long id) {
        return userRepo.getOne(id);
    }

    public User update(User user) {
        return userRepo.saveAndFlush(user);
    }

    public void addUser(User user) {
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setAge(user.getAge());
        userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
