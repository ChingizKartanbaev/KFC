package com.project.KFC.services.impl;

import com.project.KFC.enums.TaskStatusEnum;
import com.project.KFC.models.Response.EmployeeTask;
import com.project.KFC.models.Task;
import com.project.KFC.repositories.TaskRep;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRep rep;
    private final EmployeeService employeeService;

    @Autowired
    public TaskServiceImpl(TaskRep rep, EmployeeService employeeService) {
        this.rep = rep;
        this.employeeService = employeeService;
    }

    @Override
    public Task save(Task t) {
        return rep.save(t);
    }

    @Override
    public Task findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Task update(Long id, Task task) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return rep.findAllNotFinishedTask();
    }

    @Override
    public void createTask(EmployeeTask employeeTask) {
        Task task = new Task();

        task.setTask(employeeTask.getTask().getTask());
        task.setTaskStatus(TaskStatusEnum.UNFINISHED);
        task.setEmployee(employeeTask.getEmployee());

        save(task);
    }
}
