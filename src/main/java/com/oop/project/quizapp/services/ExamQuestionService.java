package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.ExamQuestionDto;
import com.oop.project.quizapp.dto.Question_AnswerDto;

import java.util.List;

public interface ExamQuestionService {
    public ExamQuestionDto createEA(ExamQuestionDto examQuestionDto);
    public List<Question_AnswerDto> getAllQuestionByExamId(Long exam_id);

    public void createQAByExamId(Long exam_id, List<ExamQuestionDto> examQuestionDtoList);

    public void deleteQAbyQuesIdByExamId(Long exam_id, List<ExamQuestionDto> examQuestionDtoList);
}
