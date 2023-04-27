package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.ExamDto;
import com.oop.project.quizapp.models.Exam;

import java.util.List;

public interface ExamService {
    public List<ExamDto> getAllExams();

    public ExamDto createExam(ExamDto examDto);
    public ExamDto updateExamById(ExamDto examDto);
}
