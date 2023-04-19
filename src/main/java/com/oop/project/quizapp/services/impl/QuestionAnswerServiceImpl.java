package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.QuestionAnswerDto;
import com.oop.project.quizapp.dto.Question_AnswerDto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.QuestionAnswerRepository;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.services.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Override
    public List<Question_AnswerDto> findQuestionAnswerByQuizId(Long quizId){
        List<Question_AnswerDto> question_answerDtos = new ArrayList<>();
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findByQuizId(quizId);
        for (QuizQuestion question:
             quizQuestions) {

            List<QuestionAnswer> questionAnswers = questionAnswerRepository.findByQuizQuestionId(question.getId());
            List<QuestionAnswerDto> questionAnswerDtos = new ArrayList<>();
            for (QuestionAnswer answer :
                    questionAnswers) {
                QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto(
                        answer.getId(), answer.getDescription(), answer.getImgAnswer(), answer.isCorrect_answer(), answer.getScore()
                );
                questionAnswerDtos.add(questionAnswerDto);
            }
            Question_AnswerDto question_answerDto = new Question_AnswerDto(
                    question.getId(), question.getDescription(), question.getImgQuiz(),
                    new HashSet<>(questionAnswerDtos)
            );
            question_answerDtos.add(question_answerDto);
        }
        return question_answerDtos;
    }
}
