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

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Page<ProductDTO> getProductsByCategoryId(Long categoryId, int page, int size, String sortField, String sortDirection) {
        Sort sort = this.createSort(sortField, sortDirection);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> products = productRepository.findByCategoryId(categoryId, pageable);
        return ProductMapper.mapToPageProductDTO(products);
    }

    @Override
    public Page<ProductDTO> createProduct(Long categoryId, ProductDTO productDTO, int page, int size, String sortField, String sortDirection) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException());
        Product product = ProductMapper.mapToProduct(productDTO);
        product.setCategory(category);
        productRepository.save(product);


        return  this.getProductsByCategoryId(categoryId, page, size, sortField, sortDirection);
    }

    private Sort createSort(String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        if (sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())) {
            sort = sort.ascending();
        } else {
            sort = sort.descending();
        }
        return sort;
    }
}


