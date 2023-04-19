package com.oop.project.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "QuizQuestion")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "imgQuiz", columnDefinition = "LONGTEXT")
    private String imgQuiz;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
