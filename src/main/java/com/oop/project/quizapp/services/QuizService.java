package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.QuizDto;
import org.springframework.stereotype.Service;

@Service
public interface QuizService {
    QuizDto createQuiz(QuizDto quizDto);
}
