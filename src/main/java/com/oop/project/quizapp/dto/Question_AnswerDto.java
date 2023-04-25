package com.oop.project.quizapp.dto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.QuizQuestion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question_AnswerDto {
    private Long id;
    private String name;
    private String description;
    private String imgQuiz;
    private Set<QuestionAnswerDto> questionAnswerSet;

}
