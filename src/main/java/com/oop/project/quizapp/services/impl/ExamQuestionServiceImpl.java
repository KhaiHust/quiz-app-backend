package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.ExamQuestionDto;
import com.oop.project.quizapp.dto.Question_AnswerDto;
import com.oop.project.quizapp.models.Exam;
import com.oop.project.quizapp.models.ExamQuestion;
import com.oop.project.quizapp.models.ExamQuestionId;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.ExamQuestionRepository;
import com.oop.project.quizapp.repositories.ExamRepository;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.services.ExamQuestionService;
import com.oop.project.quizapp.services.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {
    @Autowired
    private ExamQuestionRepository examQuestionRepository;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private QuestionAnswerService questionAnswerService;
    @Override
    public List<Question_AnswerDto>  getAllQuestionByExamId(Long exam_id) {
        List<ExamQuestion> examQuestionDtoList = examQuestionRepository.findByExamId(exam_id);
        List<Question_AnswerDto> question_answerDtoList = new ArrayList<>();
        for (ExamQuestion examQuestion : examQuestionDtoList){
            Question_AnswerDto question_answerDto = questionAnswerService
                    .getQuestionById(examQuestion.getQuestion().getId());
            question_answerDtoList.add(question_answerDto);
        }
        return question_answerDtoList;
    }

    @Override
    public ExamQuestionDto createEA(ExamQuestionDto examQuestionDto) {



        ExamQuestion examQuestion = examQuestionRepository.save(mapToEnity(examQuestionDto));


        return mapToDto(examQuestion);
    }

    public ExamQuestion mapToEnity(ExamQuestionDto examQuestionDto){
        ExamQuestion examQuestion = new ExamQuestion();
        ExamQuestionId examQuestionId = new ExamQuestionId(examQuestionDto.getExamId(), examQuestionDto.getQuizQuestionId());
        examQuestion.setId(examQuestionId);

        QuizQuestion quizQuestion = quizQuestionRepository.findById(examQuestionDto.getQuizQuestionId()).orElseThrow(() -> new RuntimeException("Quiz question not found"));
        examQuestion.setQuestion(quizQuestion);

        Exam exam = examRepository.findById(examQuestionDto.getExamId()).orElseThrow(() -> new RuntimeException("Exam not found"));
        examQuestion.setExam(exam);

        return examQuestion;
    }

    public ExamQuestionDto mapToDto(ExamQuestion examQuestion){
        ExamQuestionDto examQuestionDto = new ExamQuestionDto();
        examQuestionDto.setExamId(examQuestion.getExam().getId());
        examQuestionDto.setQuizQuestionId(examQuestion.getQuestion().getId());
        return examQuestionDto;
    }
}
