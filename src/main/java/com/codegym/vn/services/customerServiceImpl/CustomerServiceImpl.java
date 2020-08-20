package com.codegym.vn.services.customerServiceImpl;

import com.codegym.vn.models.Customer;
import com.codegym.vn.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer remove(Long id) {
        Customer customer = this.findById(id);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public Customer save(Customer model) {
        return customerRepository.save(model);
    }
}