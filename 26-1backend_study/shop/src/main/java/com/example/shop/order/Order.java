package com.example.shop.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {

    private Long id;
    private Long memberId;      // 주문한 회원 ID
    private Long productId;     // 주문한 상품 ID
    private int orderQuantity;  // 주문 수량
    private int totalPrice;     // 총 주문 가격
    private LocalDateTime orderDate; // 주문 시간

    public Order(Long memberId, Long productId, int orderQuantity, int totalPrice) {
        this.memberId = memberId;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now(); // 생성 시점의 시간 저장
    }
}