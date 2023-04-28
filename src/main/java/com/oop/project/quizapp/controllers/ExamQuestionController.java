package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.ExamQuestionDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/examquestion")
public class ExamQuestionController {
    @Autowired
    private ExamQuestionService examQuestionService;

    @GetMapping("/exam_id={exam_id}")
    public ResponseEntity<ResponeObject> getQuestionByExamId(
            @PathVariable Long exam_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","get success",examQuestionService.getAllQuestionByExamId(exam_id))
        );
    }

    @PostMapping
    public ResponseEntity<ResponeObject> createEA(
            @RequestBody ExamQuestionDto examQuestionDto
            ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","create a EA success",examQuestionService.createEA(examQuestionDto))
        );
    }
    @PostMapping("/exam_id={exam_id}")
    public ResponseEntity<ResponeObject> createQuestionByExamId(
            @PathVariable Long exam_id, @RequestBody List<ExamQuestionDto> examQuestionDtoList
            ){
        examQuestionService.createQAByExamId(exam_id, examQuestionDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200","create success","")
        );
    }
    @DeleteMapping("/exam_id={exam_id}")
    public  ResponseEntity<ResponeObject> deleteQuestionByExamId(
            @PathVariable Long exam_id, @RequestBody ExamQuestionDto examQuestionDtoList
    ){
        examQuestionService.deleteQAbyQuesIdByExamId(exam_id, examQuestionDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(
                new com.oop.project.quizapp.models.ResponeObject("200","delete success","")
        );
    }
}
