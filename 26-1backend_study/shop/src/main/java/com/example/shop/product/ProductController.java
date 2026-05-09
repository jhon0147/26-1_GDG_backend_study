package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 1. 상품 등록
    @PostMapping
    public Long createProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }

    // 2. 전체 상품 조회
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 3. 특정 상품 조회
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // 4. 상품 수정
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequest request) {
        productService.updateProduct(id, request);
    }

    // 5. 상품 삭제
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}