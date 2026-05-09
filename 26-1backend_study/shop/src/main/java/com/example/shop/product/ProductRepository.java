package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    //상품 저장
    public void save(Product product) {
        em.persist(product);
    }

    //ID로 상품 조회
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    //전체 상품 조회
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    //ID로 상품 삭제
    public void deleteById(Long id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }
}