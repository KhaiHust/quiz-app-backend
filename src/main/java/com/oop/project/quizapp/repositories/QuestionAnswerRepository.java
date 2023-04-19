package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer,Long> {
    List<QuestionAnswer> findByQuizQuestionId(Long quiz_question_id);
}
