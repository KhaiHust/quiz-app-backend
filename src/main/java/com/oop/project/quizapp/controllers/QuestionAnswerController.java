package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.ImportQA;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.QuestionAnswerService;
import com.oop.project.quizapp.services.impl.QuestionAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerService questionAnswerService;
    @GetMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> getAllQuestionAnswerByQuizId(
            @PathVariable Long quiz_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success",
                        questionAnswerService.findQuestionAnswerByQuizId(quiz_id))
        );
    }
    @GetMapping("/subquiz/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> getAllQASubQuiz(@PathVariable Long quiz_id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success",questionAnswerService.findQASubCateByQuizId(quiz_id))
        );
    }
    @PostMapping("/quiz_id={quiz_id}")
    public ResponseEntity<ResponeObject> createQA(@PathVariable Long quiz_id, @RequestBody List<ImportQA> importQAList){
        questionAnswerService.createQA(importQAList, quiz_id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","post success", "")
        );
    }
    @PutMapping("/question_id={question_id}")
    public ResponseEntity<ResponeObject> updateQA(
            @PathVariable(name = "question_id") Long question_id,
            @RequestBody ImportQA importQA
    ){
        questionAnswerService.updateQA(question_id,importQA);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","put success", "")
        );
    }

    @GetMapping("/quizId={quizId}/pageNo={pageNo}/pageSize={pageSize}")
    public ResponseEntity<ResponeObject> getQAPagination(
            @PathVariable(value = "quizId") Long quizId,
            @PathVariable(value = "pageNo") Long pageNo,
            @PathVariable(value = "pageSize") Long pageSize
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
             new ResponeObject("200","get success",questionAnswerService.QAwithPagination(quizId, pageNo,pageSize)
             )
        );

    }
}
