package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepositories extends JpaRepository<Quiz, Long> {
}
