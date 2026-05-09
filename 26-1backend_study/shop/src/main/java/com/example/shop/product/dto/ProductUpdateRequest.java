package com.example.shop.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateRequest {
    private String name;
    private int price;
    private int stockQuantity;
}