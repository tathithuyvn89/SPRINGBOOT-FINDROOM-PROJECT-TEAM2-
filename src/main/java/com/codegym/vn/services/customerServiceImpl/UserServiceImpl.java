package com.codegym.vn.services.customerServiceImpl;

import com.codegym.vn.models.Role;
import com.codegym.vn.models.User;
import com.codegym.vn.models.UserPrincipal;
import com.codegym.vn.repositories.UserRepository;
import com.codegym.vn.services.roleServiceImpl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
  public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User remove(Long id) {
        User user = this.findById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User save(User model) {
        if (model.getRoles() == null){
            Role role = roleService.findByName("ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            model.setRoles(roles);
        }
        model.setPassword(passwordEncoder.encode(model.getPassword()));

        return userRepository.save(model);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));
        if (!userOptional.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return UserPrincipal.build(userOptional.get());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}