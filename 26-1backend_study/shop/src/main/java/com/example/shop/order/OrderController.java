package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문 생성
    @PostMapping
    public Long createOrder(@RequestBody OrderCreateRequest request) {
        return orderService.createOrder(request);
    }

    // 주문 목록 조회
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // 개별 주문 정보 조회
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // 주문 취소
    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

    
}