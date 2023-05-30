package com.oop.project.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ExamDto {
    private Long id;
    private String name;
    private String description;
    private Long timeLimit;
    private Boolean suffer;
}
