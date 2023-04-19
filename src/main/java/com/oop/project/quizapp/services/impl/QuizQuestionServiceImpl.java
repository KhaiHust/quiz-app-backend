package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.QuestionDto;
import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.dto.QuizQuestionDto;
import com.oop.project.quizapp.dto.Quiz_QuestionDto;
import com.oop.project.quizapp.models.QuestionMark;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.QuestionMarkRepository;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.repositories.QuizRepositories;
import com.oop.project.quizapp.services.QuizQuestionService;
import com.oop.project.quizapp.services.QuizService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {
    @Autowired
    private QuizRepositories quizRepositories;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private QuestionMarkRepository questionMarkRepository;
    @Override
    public Quiz_QuestionDto getAllQuestionByQuizId(Long id) {
        Quiz quiz = quizRepositories.findById(id).orElseThrow(null);

        List<QuizQuestion> quizQuestion = quizQuestionRepository.findByQuizId(quiz.getId()).stream().toList();
        List<QuizQuestionDto> quizQuestionDtos = new ArrayList<>();
        for (QuizQuestion question : quizQuestion){
            QuizQuestionDto quizQuestionDto = new QuizQuestionDto();
            quizQuestionDto.setId(question.getId());
            quizQuestionDto.setDescription(question.getDescription());
            quizQuestionDto.setImgQuiz(question.getImgQuiz());
            quizQuestionDtos.add(quizQuestionDto);
        }
        Quiz_QuestionDto quiz_QuestionDto = new Quiz_QuestionDto();
        quiz_QuestionDto.setId(quiz.getId());
        quiz_QuestionDto.setName(quiz.getName());
        quiz_QuestionDto.setDescription(quiz.getDescription());
        quiz_QuestionDto.setCategory_id(quiz.getCategory_id());
        quiz_QuestionDto.setQuizQuestionSet(new HashSet<>(quizQuestionDtos));
        return quiz_QuestionDto;
    }

//    @Override
//    public QuestionDto createQuestion(Long quizId,QuestionDto questionDto) {
//
////        QuestionMark questionMark = questionMarkRepository.getOne(questionDto.getId());
////
////        QuizQuestion quizQuestion = new QuizQuestion();
////        questionMark.setMark(questionDto.getQuestion_mark());
////
////        QuizQuestion quizQuestion = new QuizQuestion();
////        quizQuestion.setDescription(questionDto.getDescription());
////        quizQuestion.setImgQuiz(questionDto.getImgQuiz());
////
////        quizQuestion.setQuestionMark(questionMark);
////        questionMark.setQuizQuestion(quizQuestion);
//
//
////        Quiz quiz = quizRepositories.findById(quizId).orElseThrow(null);
////        quizQuestion.setDescription(quizQuestionDto.getDescription());
////        quizQuestion.se
//
//    }
}
