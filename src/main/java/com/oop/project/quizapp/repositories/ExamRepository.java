package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository  extends JpaRepository<Exam, Long> {
}
