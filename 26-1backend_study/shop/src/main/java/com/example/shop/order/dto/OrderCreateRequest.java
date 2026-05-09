package com.example.shop.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreateRequest {
    private Long memberId;
    private Long productId;
    private int count; // 주문 수량
}