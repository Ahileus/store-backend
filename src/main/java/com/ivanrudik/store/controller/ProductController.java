package com.ivanrudik.store.controller;

import com.ivanrudik.store.dto.ProductDTO;
import com.ivanrudik.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category/{categoryId}/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> getProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        return productService.getProductsByCategoryId(categoryId, page, size, sortField, sortDirection);
    }

    @PostMapping
    public Page<ProductDTO> saveProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        return productService.createProduct(categoryId, productDTO, page, size, sortField, sortDirection);
    }
}
