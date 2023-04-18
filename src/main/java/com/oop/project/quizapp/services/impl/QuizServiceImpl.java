package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.repositories.QuizRepositories;
import com.oop.project.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepositories quizRepositories;

    @Override
    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = mapToEntity(quizDto);
        Quiz newQuiz = quizRepositories.save(quiz);
        QuizDto responeQuiz = mapToDTO(newQuiz);
        return responeQuiz;
    }

    private Quiz mapToEntity(QuizDto quizDto){
        Quiz quiz = new Quiz();
        quiz.setName(quizDto.getName());
        quiz.setDescription(quizDto.getDescription());
        quiz.setCategory_id(quiz.getCategory_id());
        return quiz;
    }
    private QuizDto mapToDTO(Quiz quiz){
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setName(quiz.getName());
        quizDto.setDescription(quiz.getDescription());
        quizDto.setCategory_id(quiz.getCategory_id());
        return quizDto;
    }
}
