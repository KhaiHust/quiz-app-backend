package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getCategoriesTree();
    public CategoryDto createCategory(CategoryDto categoryDto);

}
