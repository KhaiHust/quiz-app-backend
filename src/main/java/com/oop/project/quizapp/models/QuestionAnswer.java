package com.oop.project.quizapp.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "QuestionAnswer")
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description",nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "imgAnswer", columnDefinition = "LONGTEXT")
    private String imgAnswer;

    @Column(name = "correct_answer", nullable = false, columnDefinition = "BOOLEAN default false")
    private boolean correct_answer;

    @Column(name = "score", nullable = false, columnDefinition = "FLOAT default 0")
    private Float score;

    @ManyToOne
    @JoinColumn(name = "quizQuestion_id")
    private QuizQuestion quizQuestion;

}
