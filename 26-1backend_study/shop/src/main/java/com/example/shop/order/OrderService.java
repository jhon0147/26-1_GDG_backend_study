package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.member.MemberRepository;
import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.product.Product;
import com.example.shop.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public Long createOrder(OrderCreateRequest request) {
        // 1. 회원 정보 조회
        Member member = memberRepository.findById(request.getMemberId());
        if (member == null) throw new RuntimeException("회원을 찾을 수 없습니다.");

        // 2. 상품 정보 조회
        Product product = productRepository.findById(request.getProductId());
        if (product == null) throw new RuntimeException("상품을 찾을 수 없습니다.");

        // 3. 재고 확인 및 감소 로직
        if (product.getStockQuantity() < request.getCount()) {
            throw new RuntimeException("상품 재고가 부족합니다. 현재 재고: " + product.getStockQuantity());
        }
        product.setStockQuantity(product.getStockQuantity() - request.getCount());

        // 4. 총 가격 계산 및 주문 생성
        int totalPrice = product.getPrice() * request.getCount();
        Order order = new Order(
                member.getId(),
                product.getId(),
                request.getCount(),
                totalPrice
        );

        // 5. 저장
        orderRepository.save(order);
        return order.getId();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) throw new RuntimeException("주문 내역을 찾을 수 없습니다.");
        return order;
    }

    public void cancelOrder(Long id) {
        // 1. 주문 내역 조회
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("취소할 주문 내역을 찾을 수 없습니다.");
        }

        // 2. 상품 재고 원복
        Product product = productRepository.findById(order.getProductId());
        if (product != null) {
            product.setStockQuantity(product.getStockQuantity() + order.getOrderQuantity());
        }

        // 3. 주문 삭제
        orderRepository.deleteById(id);
    }
}