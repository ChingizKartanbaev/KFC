package com.project.KFC.models.Response;

import com.project.KFC.models.Products;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Basket {

    Products products;
    double cost;
    int amount;
    Long productId;

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + products +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }
}
