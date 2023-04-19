package com.oop.project.quizapp.repositories;

import com.oop.project.quizapp.models.QuestionMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionMarkRepository extends JpaRepository<QuestionMark, Long> {
}
