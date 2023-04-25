package com.project.KFC.services.impl;

import com.project.KFC.models.Customer;
import com.project.KFC.models.Employee;
import com.project.KFC.models.Response.UserEmployee;
import com.project.KFC.models.User;
import com.project.KFC.repositories.UserRep;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
        return rep.save(t);
    }

    @Override
    public User findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
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
        return rep.findAll();
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

    @Override
    public void saveCustomer(User user) {
        Customer customer = new Customer();
        customer.setUser(rep.save(user));
        customerService.save(customer);
    }

    @Override
    public void logout() {
        customerService.setCustomer(null);
        employeeService.setEmployee(null);
    }

    @Override
    public User updateEmployee(Long id, User user) {
        User user1 = findById(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setBirhtdate(user.getBirhtdate());
        user1.setPassword(user.getPassword());
        user1.setLogin(user.getLogin());
        return save(user);
    }

    @Override
    public void saveWorker(UserEmployee userEmployee) {
        User user = new User();
        Employee employee = new Employee();

        user.setFirstName(userEmployee.getUser().getFirstName());
        user.setLastName(userEmployee.getUser().getLastName());
        user.setBirhtdate(userEmployee.getUser().getBirhtdate());
        user.setLogin(userEmployee.getUser().getLogin());
        user.setPassword(userEmployee.getUser().getPassword());
        save(user);

        employee.setUser(user);
        employee.setSalary(userEmployee.getEmployee().getSalary());
        employee.setHireDate(LocalDateTime.now());
        employee.setPosition(userEmployee.getPosition());

        employeeService.save(employee);
    }
}
