package com.codegym.vn.services.customerServiceImpl;

import com.codegym.vn.models.User;
import com.codegym.vn.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public User findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public User remove(Long id) {
        User user = this.findById(id);
        customerRepository.deleteById(id);
        return user;
    }

    @Override
    public User save(User model) {
        return customerRepository.save(model);
    }
}