package com.example.shop.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    // 메모리 저장소 (Key: 상품 ID, Value: 상품 객체)
    private final Map<Long, Product> store = new HashMap<>();

    // ID 자동 생성기
    private long sequence = 0L;

    // 상품 저장
    public Product save(Product product) {
        if (product.getId() == null) {
            sequence++;
            product.setId(sequence);
        }
        store.put(product.getId(), product);
        return product;
    }

    // 전체 상품 조회
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    // ID로 특정 상품 조회
    public Product findById(Long id) {
        return store.get(id);
    }

    // 상품 삭제
    public void deleteById(Long id) {
        store.remove(id);
    }

    // 데이터 초기화 (테스트용)
    public void clearStore() {
        store.clear();
    }
}