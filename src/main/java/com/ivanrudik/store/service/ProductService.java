package com.ivanrudik.store.service;

import com.ivanrudik.store.dto.ProductDTO;
import org.springframework.data.domain.Page;

public interface ProductService {
    public Page<ProductDTO> getProductsByCategoryId(Long categoryId, int page, int size, String sortField, String sortDirection);
    public Page<ProductDTO> createProduct(Long categoryId, ProductDTO productDTO, int page, int size, String sortField, String sortDirection);
    public Page<ProductDTO> updateProduct(Long categoryId, ProductDTO productDTO, int page, int size, String sortField, String sortDirection);
}
