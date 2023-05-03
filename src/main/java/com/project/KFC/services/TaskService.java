package com.project.KFC.services;

import com.project.KFC.enums.TaskStatusEnum;
import com.project.KFC.models.Response.EmployeeTask;
import com.project.KFC.models.Task;

import java.util.List;

public interface TaskService extends BaseService<Task> {

    void createTask(EmployeeTask employeeTask);

    List<Task> findTaskByIdAndStatus(Long id, TaskStatusEnum statusEnum);
}
