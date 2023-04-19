package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.QuestionDto;
import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.dto.QuizQuestionDto;
import com.oop.project.quizapp.dto.Quiz_QuestionDto;
import com.oop.project.quizapp.models.QuizQuestion;

import java.util.List;

public interface QuizQuestionService {


    public Quiz_QuestionDto getAllQuestionByQuizId(Long id);

    public QuestionDto createQuestion(Long quizId, QuestionDto questionDto);
}
