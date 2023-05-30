package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.ExamDto;
import com.oop.project.quizapp.models.Exam;
import com.oop.project.quizapp.repositories.ExamRepository;
import com.oop.project.quizapp.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Override
    public List<ExamDto> getAllExams() {
        List<Exam> examList = examRepository.findAll();
        List<ExamDto> examDtos = new ArrayList<>();
        if (examList.size() > 0){
            for (Exam exam : examList){
                examDtos.add(mapToDto(exam));
            }
        }
        return examDtos;
    }

    @Override
    public ExamDto createExam(ExamDto examDto) {
        Exam exam = mapToEntity(examDto);
        return mapToDto(examRepository.save(exam));
    }
    @Override
    public ExamDto updateExamById(ExamDto examDto){
        Exam exam = examRepository.findById(examDto.getId()).orElseThrow(null);
        exam = mapToEntity(examDto);
        return mapToDto(examRepository.save(exam));
    }
    public ExamDto mapToDto(Exam exam){
        return new ExamDto(
                exam.getId(), exam.getName(), exam.getDescription(), exam.getTimeLimit(), exam.getSuffer()
        );
    }
    public Exam mapToEntity(ExamDto examDto){
        Exam exam = new Exam();
        exam.setId(examDto.getId());
        exam.setName(examDto.getName());
        exam.setDescription(examDto.getDescription());
        exam.setTimeLimit(examDto.getTimeLimit());
        exam.setSuffer(examDto.getSuffer());
        return exam;
    }
}
