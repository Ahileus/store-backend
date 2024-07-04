package com.ivanrudik.store.mapper;

import com.ivanrudik.store.dto.CategoryDTO;
import com.ivanrudik.store.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static CategoryDTO mapToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setProducts(ProductMapper.mapToListProductDTO(category.getProducts()));
        return categoryDTO;
    }
}
