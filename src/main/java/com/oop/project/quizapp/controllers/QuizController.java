package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.QuizDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuizService;
import com.oop.project.quizapp.services.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizServiceImpl quizService;


    @PostMapping
    public ResponseEntity<ResponeObject> createNewQuiz(@RequestBody QuizDto quizDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
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
    @PutMapping("/{id}")
    public  ResponseEntity<ResponeObject> updateQuizById(@RequestBody QuizDto quizDto, @PathVariable Long id){
        quizService.updateQuizById(quizDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","update success","")
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponeObject> deleteQuizById(@PathVariable Long id){
        quizService.deleteQuizById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","delete success","")
        );
    }
}
