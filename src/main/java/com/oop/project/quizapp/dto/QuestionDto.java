package com.oop.project.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class QuestionDto {
    private Long id;

    private String description;

    private String imgQuiz;

    private float question_mark;
}
