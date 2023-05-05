package com.project.KFC.models.Response;


import com.project.KFC.models.Employee;
import com.project.KFC.models.Task;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeTask {
    Employee employee;
    Task task;
}
