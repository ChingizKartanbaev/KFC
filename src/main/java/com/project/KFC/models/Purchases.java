package com.project.KFC.models;

import com.project.KFC.enums.PurchasesStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_purchases")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;

    int count;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @OneToOne
    @JoinColumn(name = "store_id")
    Store store;

    LocalDateTime date;

    double totalPrice;

    @Enumerated(EnumType.STRING)
    PurchasesStatusEnum purchasesStatusEnum;
}
