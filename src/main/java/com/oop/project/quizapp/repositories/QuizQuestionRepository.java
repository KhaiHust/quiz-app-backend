package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.dto.Pagination;
import com.oop.project.quizapp.models.QuizQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Updated import statement
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    List<QuizQuestion> findByQuizId(Long quizId);
    Long countByQuizId(Long quizId);
    Page<QuizQuestion> findByQuizId(Long quizId, Pageable pageable);
}
