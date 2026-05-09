package com.example.shop.order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<Long, Order> store = new HashMap<>();
    private long sequence = 0L;

    public Order save(Order order) {
        if (order.getId() == null) {
            sequence++;
            order.setId(sequence);
        }
        store.put(order.getId(), order);
        return order;
    }

    public Order findById(Long id) {
        return store.get(id);
    }

    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id) {
        store.remove(id);
    }
}