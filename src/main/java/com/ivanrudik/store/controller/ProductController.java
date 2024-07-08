package com.ivanrudik.store.controller;

import com.ivanrudik.store.dto.ProductDTO;
import com.ivanrudik.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category/{categoryId}/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> getProductsByCategoryId(
            @PathVariable Long categoryId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortField,
//            @RequestParam(defaultValue = "asc") String sortDirection,
            Pageable pageable) {
        return productService.getProductsByCategoryId(categoryId, pageable);
    }

    @PostMapping
    public Page<ProductDTO> saveProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortField,
//            @RequestParam(defaultValue = "asc") String sortDirection,
            Pageable pageable) {
        return productService.createProduct(categoryId, productDTO, pageable);
    }

    @PutMapping
    public Page<ProductDTO> updateProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortField,
//            @RequestParam(defaultValue = "asc") String sortDirection,
            Pageable pageable) {
        return productService.updateProduct(categoryId, productDTO, pageable);
    }

    @DeleteMapping("/{productId}")
    public Page<ProductDTO> deleteProductsByCategoryId(
            @PathVariable Long categoryId,
            @PathVariable Long productId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortField,
//            @RequestParam(defaultValue = "asc") String sortDirection,
            Pageable pageable) {
        return productService.deleteProduct(categoryId, productId, pageable);
    }
}
