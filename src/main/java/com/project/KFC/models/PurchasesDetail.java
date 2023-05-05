package com.project.KFC.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_purchases_detail")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchasesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int amount;

    @ManyToOne
    @JoinColumn(name = "purchases_id")
    Purchases purchases;

    @ManyToOne
    @JoinColumn(name = "products_id")
    Products products;
}
