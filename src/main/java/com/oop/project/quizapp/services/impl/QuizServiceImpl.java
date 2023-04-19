package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.repositories.QuizRepositories;
import com.oop.project.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepositories quizRepositories;

    @Override
    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = mapToEntity(quizDto);
        Quiz newQuiz = quizRepositories.save(quiz);
        QuizDto responeQuiz = mapToDTO(newQuiz);
        return responeQuiz;
    }

    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> quizList = quizRepositories.findAll();
        List<QuizDto> quizDtoList = quizList.stream().map(quiz -> mapToDTO(quiz)).collect(Collectors.toList());
        return quizDtoList;
    }

    private Quiz mapToEntity(QuizDto quizDto){
        Quiz quiz = new Quiz();
        quiz.setName(quizDto.getName());
        quiz.setDescription(quizDto.getDescription());
        quiz.setCategory_id(quizDto.getCategory_id());
        return quiz;
    }
    private QuizDto mapToDTO(Quiz quiz){
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setName(quiz.getName());
        quizDto.setDescription(quiz.getDescription());
        quizDto.setCategory_id(quiz.getCategory_id());
        return quizDto;
    }

    @Override
    public void updateQuizById(QuizDto quizDto, Long id) {
        Quiz quiz = quizRepositories.findById(id).orElseThrow(null);
        Quiz newQuiz = mapToEntity(quizDto);
       if(quiz == null) quizRepositories.save(newQuiz);
       else {
           quiz.setName(newQuiz.getName());
           quiz.setDescription(newQuiz.getDescription());
           quizRepositories.save(quiz);
       }
    }
}
