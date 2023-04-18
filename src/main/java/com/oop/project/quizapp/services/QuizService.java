package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.QuizDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {

    QuizDto createQuiz(QuizDto quizDto);
    List<QuizDto> getAllQuiz();
}
