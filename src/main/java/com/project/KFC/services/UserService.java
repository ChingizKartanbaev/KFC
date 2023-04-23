package com.project.KFC.services;

import com.project.KFC.models.Employee;
import com.project.KFC.models.User;

public interface UserService extends BaseService<User> {

    String auth(String login, String password);

    void saveCustomer(User user);

    void logout();

    User updateEmployee(Long id, User user);
}
