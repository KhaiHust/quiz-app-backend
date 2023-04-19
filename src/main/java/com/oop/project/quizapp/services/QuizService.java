package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.Quiz;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {

    QuizDto createQuiz(QuizDto quizDto);
    List<QuizDto> getAllQuiz();
    void updateQuizById(QuizDto quizDto, Long id);
    void deleteQuizById(Long id);


}
