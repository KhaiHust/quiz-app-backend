package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.CategoryDto;
import com.oop.project.quizapp.models.Category;
import com.oop.project.quizapp.repositories.CategoryRepository;
import com.oop.project.quizapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoriesTree() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParent() == null) {
                CategoryDto categoryDto = buildCategoryDto(category);
                categoryDtos.add(categoryDto);
            }
        }
        return categoryDtos;
    }
    private CategoryDto buildCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        List<CategoryDto> children = new ArrayList<>();
        for (Category child : category.getChildren()) {
            children.add(buildCategoryDto(child));
        }
        categoryDto.setChildren(children);
        return categoryDto;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentID() != null) {
            Category parent = categoryRepository.findById(categoryDto.getParentID())
                    .orElseThrow(() -> new IllegalArgumentException("Parent category not found"));
            category.setParent(parent);
        }
        Category savedCategory = categoryRepository.save(category);
        CategoryDto categoryDto1 = new CategoryDto();
        categoryDto1.setId(savedCategory.getId());
        categoryDto1.setName(savedCategory.getName());
        return categoryDto1;
    }
}
