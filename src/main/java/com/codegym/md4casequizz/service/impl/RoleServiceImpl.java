package com.codegym.md4casequizz.service.impl;

import com.codegym.md4casequizz.model.Role;
import com.codegym.md4casequizz.model.RoleName;
import com.codegym.md4casequizz.repository.IRoleRepository;
import com.codegym.md4casequizz.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
