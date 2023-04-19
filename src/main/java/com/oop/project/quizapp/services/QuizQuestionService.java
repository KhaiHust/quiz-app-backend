package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.dto.Quiz_QuestionDto;

import java.util.List;

public interface QuizQuestionService {


    public Quiz_QuestionDto getAllQuestionByQuizId(Long id);
}
