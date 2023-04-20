package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.ImportQA;
import com.oop.project.quizapp.dto.QuestionAnswerDto;
import com.oop.project.quizapp.dto.Question_AnswerDto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.QuestionAnswerRepository;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.repositories.QuizRepositories;
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
    @Autowired
    private QuizRepositories quizRepositories;
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

    @Override
    public void createQA(List<ImportQA> importQAS, Long quizId) {
        Quiz quiz = quizRepositories.findById(quizId).orElseThrow(null);

        for (ImportQA importQA:
             importQAS) {
            QuizQuestion question = new QuizQuestion();
            question.setDescription(importQA.getDescription());
            question.setMark(importQA.getQuestion_mark());
            question.setImgQuiz(importQA.getImgQuestion());
            question.setQuiz(quiz);
            quiz.getQuizQuestions().add(question);

            QuizQuestion question1 = quizQuestionRepository.save(question);
            quizRepositories.save(quiz);

            for (QuestionAnswerDto answer :
                    importQA.getQuestionAnswerDtos()) {
                QuestionAnswer newAnswer = new QuestionAnswer();
                newAnswer.setDescription(answer.getDescription());
                newAnswer.setImgAnswer(answer.getImgAnswer());
                newAnswer.setCorrect_answer(answer.isCorrect_answer());
                newAnswer.setScore(answer.getScore());
                newAnswer.setQuizQuestion(question1);
                question1.getQuestionAnswers().add(newAnswer);

                questionAnswerRepository.save(newAnswer);

                quizQuestionRepository.save(question1);
            }
        }

    }

    @Override
    public void updateQA(Long questionId, ImportQA importQA) {
        QuizQuestion question = quizQuestionRepository.findById(questionId).orElseThrow(null);
        question.setDescription(importQA.getDescription());
        question.setImgQuiz(importQA.getImgQuestion());
        question.setMark(importQA.getQuestion_mark());

        for (QuestionAnswerDto answerDto : importQA.getQuestionAnswerDtos()) {
            if (answerDto.getId() != null) {
                // Update existing QuestionAnswer
                QuestionAnswer answer = questionAnswerRepository.findById(answerDto.getId())
                        .orElseThrow(null);
                answer.setDescription(answerDto.getDescription());
                answer.setImgAnswer(answerDto.getImgAnswer());
                answer.setCorrect_answer(answerDto.isCorrect_answer());
                answer.setScore(answerDto.getScore());
                answer.setQuizQuestion(question);
                questionAnswerRepository.save(answer);
            } else {
                // Create new QuestionAnswer
                QuestionAnswer answer = new QuestionAnswer();
                answer.setDescription(answerDto.getDescription());
                answer.setImgAnswer(answerDto.getImgAnswer());
                answer.setCorrect_answer(answerDto.isCorrect_answer());
                answer.setScore(answerDto.getScore());
                answer.setQuizQuestion(question);
                question.getQuestionAnswers().add(answer);
                questionAnswerRepository.save(answer);
            }
        }
        quizQuestionRepository.save(question);
    }

}
