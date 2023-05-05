package com.project.KFC.models.Response;

import com.project.KFC.models.Employee;
import com.project.KFC.models.Position;
import com.project.KFC.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEmployee {
    User user;
    Employee employee;
    Position position;
}
