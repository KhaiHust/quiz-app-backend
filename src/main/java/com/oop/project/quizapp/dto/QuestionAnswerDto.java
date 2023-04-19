package com.oop.project.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionAnswerDto {
    private Long id;
    private String description;
    private String imgAnswer;
    private boolean correct_answer;
    private float score;
}
