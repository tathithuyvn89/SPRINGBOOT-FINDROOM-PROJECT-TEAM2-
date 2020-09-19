package com.codegym.vn.services.userServiceImpl;


import com.codegym.vn.models.auth_security.AccountPrinciple;
import com.codegym.vn.models.auth_security.RoleName;
import com.codegym.vn.models.user.Role;
import com.codegym.vn.models.user.User;
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
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
    public User save(User user) {
        Set<Role> rolesUser = new HashSet<>();
        if (user.getRoles()==null) {
            Role roleUser = roleService.findRoleByName(RoleName.ROLE_USER.toString());
            rolesUser.add(roleUser);
            user.setRoles(rolesUser);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>  userOptional = userRepository.findUserByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return AccountPrinciple.build(userOptional.get());
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
       return userRepository.findUserByUsername(username);
    }
}