package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 등록
    public Long createProduct(ProductCreateRequest request) {
        Product product = new Product(
                request.getName(),
                request.getPrice(),
                request.getStockQuantity()
        );

        productRepository.save(product);
        return product.getId();
    }

    // 전체 상품 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    // 상품 정보 수정
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }


        product.updateInfo(request.getName(), request.getPrice(), request.getStockQuantity());
    }

    // 상품 삭제
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        productRepository.deleteById(id);
    }
}