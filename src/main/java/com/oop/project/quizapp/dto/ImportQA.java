package com.oop.project.quizapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImportQA {
    private Long id;

    private String description;

    private String imgQuestion;

    private float question_mark;

    private List<QuestionAnswerDto> questionAnswerDtos;
}
