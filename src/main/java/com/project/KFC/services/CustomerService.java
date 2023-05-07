package com.project.KFC.services;

import com.project.KFC.models.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer>{

    boolean findCustomer(String login, String password);

    Customer getCustomer();

    void setCustomer(Customer customer);

    List<Customer> getProcessPurchasesFromCustomer();
}
