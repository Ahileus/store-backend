package com.ivanrudik.store.service.Impl;

import com.ivanrudik.store.dto.CategoryDTO;
import com.ivanrudik.store.dto.ProductDTO;
import com.ivanrudik.store.entity.Category;
import com.ivanrudik.store.entity.Product;
import com.ivanrudik.store.mapper.CategoryMapper;
import com.ivanrudik.store.mapper.ProductMapper;
import com.ivanrudik.store.repository.CategoryRepository;
import com.ivanrudik.store.repository.ProductRepository;
import com.ivanrudik.store.service.CategoryService;
import com.ivanrudik.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Override
    public Page<ProductDTO> getProductsByCategoryId(Long categoryId, Pageable pageable) {
        //Sort sort = this.createSort(sortField, sortDirection);
        //Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> products = productRepository.findByCategoryId(categoryId, pageable);
        return ProductMapper.mapToPageProductDTO(products);
    }

    @Override
    public Page<ProductDTO> createProduct(Long categoryId, ProductDTO productDTO, Pageable pageable) {
        Category category = CategoryMapper.mapToCategory(categoryService.getCategoryById(categoryId));
        Product product = ProductMapper.mapToProduct(productDTO);
        product.setCategory(category);
        productRepository.save(product);
        return this.getProductsByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<ProductDTO> updateProduct(Long categoryId, ProductDTO productDTO, Pageable pageable) {
        Product product = productRepository
                .findById(productDTO.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        productRepository.save(product);
        return this.getProductsByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<ProductDTO> deleteProduct(Long categoryId, Long productId, Pageable pageable) {
        productRepository.deleteById(productId);
        return this.getProductsByCategoryId(categoryId, pageable);
    }

//    private Sort createSort(String sortField, String sortDirection) {
//        Sort sort = Sort.by(sortField);
//        if (sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())) {
//            sort = sort.ascending();
//        } else {
//            sort = sort.descending();
//        }
//        return sort;
//    }
}



