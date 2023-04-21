package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.CategoryDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/tree")
    public ResponseEntity<ResponeObject> getCategoryTree(){
        List<CategoryDto> categoryDtoList = categoryService.getCategoriesTree();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200", "get success", categoryDtoList)
        );
    }
    @PostMapping
    public ResponseEntity<ResponeObject> createCaretory(@RequestBody CategoryDto categoryDto){

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200", "get success", categoryService.createCategory(categoryDto))
        );
    }
}
