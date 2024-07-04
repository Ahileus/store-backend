package com.ivanrudik.store.service.Impl;

import com.ivanrudik.store.dto.CategoryDTO;
import com.ivanrudik.store.entity.Category;
import com.ivanrudik.store.mapper.CategoryMapper;
import com.ivanrudik.store.repository.CategoryRepository;
import com.ivanrudik.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.mapToCategory(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryMapper::mapToCategoryDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return CategoryMapper.mapToCategoryDTO(category);
    }
}
