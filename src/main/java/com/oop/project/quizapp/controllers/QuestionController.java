package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.QuizQuestionDto;
import com.oop.project.quizapp.dto.Quiz_QuestionDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuizQuestionService;
import com.oop.project.quizapp.services.impl.QuizQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    private QuizQuestionServiceImpl quizQuestionService;
    @GetMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> getALlQuestionByQuizId(@PathVariable Long quiz_id){
        Quiz_QuestionDto quiz_questionDto = quizQuestionService.getAllQuestionByQuizId(quiz_id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success", quiz_questionDto)
        );
    }

}
