package com.project.KFC.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    Date hireDate;

    double salary;

    @OneToOne
    @JoinColumn(name = "position_id")
    Position position;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
