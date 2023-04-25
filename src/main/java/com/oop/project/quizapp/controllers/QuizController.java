package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuestionAnswerService;
import com.oop.project.quizapp.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestionAnswerService questionAnswerService;
    @PostMapping
    public ResponseEntity<ResponeObject> createNewQuiz(@RequestBody QuizDto quizDto){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","create new quiz success",quizService.createQuiz(quizDto))
        );
    }
    @GetMapping
    public  ResponseEntity<ResponeObject> getAllQuiz(){
       List<QuizDto> quizDtoList = quizService.getAllQuiz();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get all quiz success", quizDtoList)
        );
    }


}
