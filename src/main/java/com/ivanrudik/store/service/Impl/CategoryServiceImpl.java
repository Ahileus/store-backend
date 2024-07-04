package com.ivanrudik.store.service.Impl;

import com.ivanrudik.store.dto.CategoryDTO;
import com.ivanrudik.store.repository.CategoryRepository;
import com.ivanrudik.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }
}
