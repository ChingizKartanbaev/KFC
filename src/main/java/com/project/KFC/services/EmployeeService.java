package com.project.KFC.services;

import com.project.KFC.models.Employee;

public interface EmployeeService extends BaseService<Employee> {

    boolean findEmployee(String login, String password);

    Employee getEmployee();

    void setEmployee(Employee employee);

    String changeSalaryUp(Long id, double newSalary);
}
