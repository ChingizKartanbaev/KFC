package com.project.KFC.services.impl;

import com.project.KFC.models.Employee;
import com.project.KFC.repositories.EmployeeRep;
import com.project.KFC.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRep rep;

    private Employee employee;

    @Autowired
    public EmployeeServiceImpl(EmployeeRep rep) {
        this.rep = rep;
    }

    @Override
    public Employee save(Employee t) {
        return rep.save(t);
    }

    @Override
    public Employee findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee update(Long id, Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return rep.findAll();
    }

    @Override
    public boolean findEmployee(String login, String password) {
        employee = rep.findEmployeeId(login, password);
        return rep.findEmployeeByByLoginAndPassword(login,password);
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String changeSalaryUp(Long id, double newSalary) {
        Employee employee1 = findById(id);
        employee1.setSalary(employee1.getSalary()+newSalary);
        save(employee1);
        return "success";
    }
}
