package com.oop.project.quizapp.controllers;

import com.oop.project.quizapp.dto.ExamDto;
import com.oop.project.quizapp.models.ResponeObject;
import com.oop.project.quizapp.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<ResponeObject> getAllExams(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200", "get success",examService.getAllExams())
        );
    }
    @PostMapping
    public ResponseEntity<ResponeObject> createAExam(
            @RequestBody ExamDto examDto
            ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("200", "get success",examService.createExam(examDto))
        );
    }
    @PutMapping("/{exam_id}")
    public ResponseEntity<ResponeObject> updateExamById(
            @RequestBody ExamDto examDto
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new com.oop.project.quizapp.models.ResponeObject("200", "get success",examService.updateExamById(examDto))
        );
    }

}
