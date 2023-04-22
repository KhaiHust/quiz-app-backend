package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.repositories.QuizRepositories;
import com.oop.project.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepositories quizRepositories;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Override
    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setName(quizDto.getName());
        quiz.setDescription(quizDto.getDescription());
        if (quizDto.getParentID() != null) {
            Quiz parent = quizRepositories.findById(quizDto.getParentID())
                    .orElseThrow(() -> new IllegalArgumentException("Parent category not found"));
            quiz.setParent(parent);
        }
        Quiz saveQuiz = quizRepositories.save(quiz);
        QuizDto quizDto1 = new QuizDto();
        quizDto1.setId(saveQuiz.getId());
        quizDto1.setName(quiz.getName());
        quizDto1.setDescription(saveQuiz.getDescription());
        return quizDto;
    }

    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> quizList = quizRepositories.findAll();
        List<QuizDto> quizDtoList = new ArrayList<>();
        for (Quiz quiz : quizList) {
            if (quiz.getParent() == null) {
                QuizDto quizDto = buildQuizDto(quiz);
                quizDtoList.add(quizDto);
            }
        }
        return quizDtoList;
    }

    private QuizDto buildQuizDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setName(quiz.getName());
        quizDto.setDescription(quiz.getDescription());
        quizDto.setTotalQuestion(countQuestion(quiz.getId()));
        List<QuizDto> children = new ArrayList<>();
        for (Quiz child : quiz.getChildren()) {
            children.add(buildQuizDto(child));
        }
        quizDto.setChildren(children);
        return quizDto;
    }

    private Long countQuestion(Long quizId){
        return quizQuestionRepository.countByQuizId(quizId);
    }

}
