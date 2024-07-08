package com.ivanrudik.store.controller;

import com.ivanrudik.store.dto.ProductDTO;
import com.ivanrudik.store.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product controller")
@RestController
@RequestMapping("/api/category/{categoryId}/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @Operation(summary = "Get products by id of category")
    @GetMapping
    public Page<ProductDTO> getProductsByCategoryId(
            @PathVariable Long categoryId,
            Pageable pageable) {
        return productService.getProductsByCategoryId(categoryId, pageable);
    }

    @Operation(summary = "Save a new product by id")
    @PostMapping
    public Page<ProductDTO> saveProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO,
            Pageable pageable) {
        return productService.createProduct(categoryId, productDTO, pageable);
    }

    @Operation(summary = "Update a product by id")
    @PutMapping
    public Page<ProductDTO> updateProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO,
            Pageable pageable) {
        return productService.updateProduct(categoryId, productDTO, pageable);
    }

    @Operation(summary = "Delete a product by id")
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
