package com.project.KFC.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_review")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String review;

    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

}
