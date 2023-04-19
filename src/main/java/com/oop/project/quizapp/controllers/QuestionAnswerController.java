package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.impl.QuestionAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/answer")
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerServiceImpl questionAnswerService;
    @GetMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> getAllQuestionAnswerByQuizId(
            @PathVariable Long quiz_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success",
                        questionAnswerService.findQuestionAnswerByQuizId(quiz_id))
        );
    }
}
