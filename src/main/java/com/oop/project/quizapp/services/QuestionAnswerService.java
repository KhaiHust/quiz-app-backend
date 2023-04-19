package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.Question_AnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionAnswerService {
    public List<Question_AnswerDto> findQuestionAnswerByQuizId(Long quizId);
}
