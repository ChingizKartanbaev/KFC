package com.project.KFC.services;

import com.project.KFC.models.Response.EmployeeTask;
import com.project.KFC.models.Task;

public interface TaskService extends BaseService<Task> {

    void createTask(EmployeeTask employeeTask);
}
