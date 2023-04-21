package com.project.KFC.services.impl;

import com.project.KFC.models.User;
import com.project.KFC.repositories.UserRep;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRep rep;
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public UserServiceImpl(UserRep rep, CustomerService customerService, EmployeeService employeeService) {
        this.rep = rep;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @Override
    public User save(User t) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }


    @Override
    public String auth(String login, String password) {
        if (customerService.findCustomer(login,password)){
            return "Customer";
        } else if (employeeService.findEmployee(login,password)){
            return employeeService.getEmployee().getPosition().getPosition();
        } else if(login.equals("admin") && password.equals("admin")){
            return "Admin";
        } else {
            return "error";
        }
    }
}
