package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    @Column(name = "order_date")
    private LocalDateTime orderDate; // 주문 시간

    @Column(name = "total_price")
    private int totalPrice;     // 총 주문 가격

    @Column(name = "point_used")
    private int pointused;

    @Column(name = "cash_amount")
    private int cashAmount;

    @Column(name = "status", length = 25)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;     // 주문한 상품 ID

    @Column(name = "order_quantity")
    private int orderQuantity;  // 주문 수량

    public Order(Member memberId, Product productId, int orderQuantity, int totalPrice) {
        this.memberId = memberId;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
    }

}