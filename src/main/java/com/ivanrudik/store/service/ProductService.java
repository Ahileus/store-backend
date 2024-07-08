package com.ivanrudik.store.service;

import com.ivanrudik.store.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Page<ProductDTO> getProductsByCategoryId(Long categoryId, Pageable pageable);
    public Page<ProductDTO> createProduct(Long categoryId, ProductDTO productDTO, Pageable pageable);
    public Page<ProductDTO> updateProduct(Long categoryId, ProductDTO productDTO, Pageable pageable);
    public Page<ProductDTO> deleteProduct(Long categoryId, Long productId, Pageable pageable);
}
