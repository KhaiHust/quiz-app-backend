package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuizService;
import com.oop.project.quizapp.services.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<ResponeObject> createNewQuiz(@RequestBody QuizDto quizDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponeObject("200","create new quiz success",quizService.createQuiz(quizDto))
        );
    }
}