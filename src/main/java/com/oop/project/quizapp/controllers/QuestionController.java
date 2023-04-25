package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.QuestionDto;
import com.oop.project.quizapp.dto.QuizQuestionDto;
import com.oop.project.quizapp.dto.Quiz_QuestionDto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuestionAnswerService;
import com.oop.project.quizapp.services.QuizQuestionService;
import com.oop.project.quizapp.services.impl.QuizQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    private QuizQuestionServiceImpl quizQuestionService;
    @Autowired
    private QuestionAnswerService questionAnswerService;
    @GetMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> getALlQuestionByQuizId(@PathVariable Long quiz_id){
        Quiz_QuestionDto quiz_questionDto = quizQuestionService.getAllQuestionByQuizId(quiz_id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success", quiz_questionDto)
        );
    }
    @PostMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> createNewQuestion(@PathVariable Long quiz_id, @RequestBody QuestionDto questionDto){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success", quizQuestionService.createQuestion(quiz_id, questionDto))
        );
    }
    @GetMapping("/{question_id}")
    public ResponseEntity<ResponeObject> getQuestionById(
            @PathVariable Long question_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success", questionAnswerService.getQuestionById(question_id))
        );
    }
}
