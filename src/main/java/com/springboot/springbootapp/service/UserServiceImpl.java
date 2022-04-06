package com.springboot.springbootapp.service;

import com.springboot.springbootapp.model.Role;
import com.springboot.springbootapp.model.User;
import com.springboot.springbootapp.repository.RoleRepo;
import com.springboot.springbootapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        user.setUsername(user.getUsername());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
