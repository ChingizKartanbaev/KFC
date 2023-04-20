package com.project.KFC.services.impl;

import com.project.KFC.models.Customer;
import com.project.KFC.repositories.CustomerRep;
import com.project.KFC.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRep rep;

    @Autowired
    public CustomerServiceImpl(CustomerRep rep) {
        this.rep = rep;
    }

    @Override
    public Customer save(Customer t) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Customer update(Long id, Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean findCustomer(String login, String password) {
        return rep.findCustomerByByLoginAndPassword(login, password);
    }
}
