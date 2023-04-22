package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepositories extends JpaRepository<Quiz, Long> {
    List<Quiz> findByParentId(Long parentId);
}
