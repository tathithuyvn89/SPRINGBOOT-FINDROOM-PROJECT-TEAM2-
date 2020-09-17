package com.codegym.vn.services.userServiceImpl;

import com.codegym.vn.models.auth_security.AccountPrinciple;
import com.codegym.vn.models.user.User;
import com.codegym.vn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

@Service
  public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
        return userRepository.save(model);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>  userOptional = userRepository.findUserByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return AccountPrinciple.build(userOptional.get());
    }
}