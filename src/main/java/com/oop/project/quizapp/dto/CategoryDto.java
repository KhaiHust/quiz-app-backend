package com.oop.project.quizapp.dto;

import com.oop.project.quizapp.models.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;

    private Long parentID;
    private Category parent;


    private List<CategoryDto> children = new ArrayList<>();


}
