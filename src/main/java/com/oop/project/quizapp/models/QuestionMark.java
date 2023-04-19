package com.oop.project.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "QuestionMark" )
public class QuestionMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mark", nullable = false)
    private float mark;

    @OneToOne(mappedBy = "questionMark" )
    private QuizQuestion quizQuestion;
}
