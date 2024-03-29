package com.oop.project.quizapp.services;

import com.oop.project.quizapp.dto.ImportQA;
import com.oop.project.quizapp.dto.Question_AnswerDto;
import com.oop.project.quizapp.models.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionAnswerService {
    public List<Question_AnswerDto> findQuestionAnswerByQuizId(Long quizId);

    public void createQA(List<ImportQA> importQAS, Long quizId);

    public void updateQA(Long questionId, ImportQA importQA);
    public List<Question_AnswerDto> findQASubCateByQuizId(Long quizId);

    public Question_AnswerDto getQuestionById(Long ques_id);

    public  List<Question_AnswerDto> QAwithPagination(Long quizId,Long pageNo, Long pageSize);
}
