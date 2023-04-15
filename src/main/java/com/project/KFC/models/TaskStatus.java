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
@Table(name = "tb_task_status")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(value = EnumType.STRING)
    TaskStatusEnum taskStatus;

}
