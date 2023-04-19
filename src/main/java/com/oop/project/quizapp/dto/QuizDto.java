package com.oop.project.quizapp.dto;

import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.models.QuizQuestion;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizDto {
    private Long id;
    private String name;

    private String description;

    private Long category_id;

}
