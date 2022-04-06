package com.springboot.springbootapp.service;

import com.springboot.springbootapp.model.Role;
import com.springboot.springbootapp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepo.getRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepo.getById(id);
    }

    @Override
    public List<Role> allRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }
}
