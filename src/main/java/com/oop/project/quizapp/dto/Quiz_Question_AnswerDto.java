package com.oop.project.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz_Question_AnswerDto {
    private Long id;
    private String name;

    private String description;

    private Long category_id;

    private Set<Question_AnswerDto> questionAnswerDtoSet;
}
