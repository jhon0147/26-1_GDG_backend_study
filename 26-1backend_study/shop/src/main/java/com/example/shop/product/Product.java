package com.example.shop.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;
    private String name;          // 상품명
    private int price;            // 가격
    private int stockQuantity;    // 재고 수량

    // 생성자 (ID는 Repository에서 할당하므로 제외)
    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // 상품 정보 수정 메서드
    public void updateInfo(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}