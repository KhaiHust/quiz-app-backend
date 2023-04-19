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
public class Quiz_QuestionDto {
    private Long id;
    private String name;

    private String description;

    private Long category_id;
    private Set<QuizQuestionDto> quizQuestionSet;

    public static Quiz_QuestionDto fromEntity(Quiz quiz){
        Quiz_QuestionDto quizDto = new Quiz_QuestionDto();
        quizDto.setId(quiz.getId());
        quizDto.setName(quiz.getName());
        quizDto.setDescription(quiz.getDescription());
        quizDto.setCategory_id(quiz.getCategory_id());
        Set<QuizQuestionDto> quizQuestionDtos = new HashSet<>();
        if (quiz.getQuizQuestions() != null){
            for (QuizQuestion quizQuestion : quiz.getQuizQuestions() ){
                QuizQuestionDto quizQuestionDto = new QuizQuestionDto();
                quizQuestionDto.setId(quizQuestion.getId());
                quizQuestionDto.setDescription(quizQuestion.getDescription());
                quizQuestionDto.setImgQuiz(quizQuestion.getImgQuiz());
                quizQuestionDtos.add(quizQuestionDto);
            }
        }
        quizDto.setQuizQuestionSet(quizQuestionDtos);
        return quizDto;
    }
}

