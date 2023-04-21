package com.oop.project.quizapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDto {
    private Long id;
    private String name;
    private String description;

    private String imgQuiz;

    private float question_mark;
}
