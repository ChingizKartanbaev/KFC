package com.project.KFC.models;

import com.project.KFC.enums.TaskStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_task")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String task;

    @OneToOne
    @JoinColumn(name = "task_status_id")
    TaskStatus taskStatus;

    @OneToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

}
