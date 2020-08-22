package com.codegym.vn.services.roleServiceImpl;

import com.codegym.vn.models.Role;
import com.codegym.vn.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role remove(Long id) {
        roleRepository.deleteById(id);
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role model) {
        roleRepository.save(model);
        return model;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
