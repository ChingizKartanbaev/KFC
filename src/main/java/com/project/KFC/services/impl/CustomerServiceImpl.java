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
    private Customer customer;

    @Autowired
    public CustomerServiceImpl(CustomerRep rep) {
        this.rep = rep;
    }

    @Override
    public Customer save(Customer t) {
        return rep.save(t);
    }

    @Override
    public Customer findById(Long id) {
        return rep.findById(id).orElseThrow(()-> new RuntimeException("not found"));
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
        return rep.findAll();
    }

    @Override
    public boolean findCustomer(String login, String password) {
        customer = rep.findCustomer(login, password);
        return rep.findCustomerByByLoginAndPassword(login, password);
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public List<Customer> getProcessPurchasesFromCustomer() {
        return rep.getProcessPurchasesFromCustomer();
    }
}
