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

    @Autowired
    public EmployeeServiceImpl(EmployeeRep rep) {
        this.rep = rep;
    }

    @Override
    public Employee save(Employee t) {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
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
        return null;
    }

    @Override
    public boolean findEmployee(String login, String password) {
        return rep.findEmployeeByByLoginAndPassword(login,password);
    }

    @Override
    public Long findEmployeeId(String login, String password) {
        return rep.findEmployeeId(login, password);
    }

    @Override
    public String employeePosition(String login, String password) {
        return rep.employeePosition(findEmployeeId(login,password));
    }
}
