package com.project.KFC.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "purchases_id", nullable = true)
    Purchases purchases;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
