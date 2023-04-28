package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.ExamQuestion;
import com.oop.project.quizapp.models.ExamQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, ExamQuestionId> {
    List<ExamQuestion> findByExamId(Long exam_id);
    void deleteByExamIdAndQuestionId(Long exam_id, Long quizQuestionId);

}
