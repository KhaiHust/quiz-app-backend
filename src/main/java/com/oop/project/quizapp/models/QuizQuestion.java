package com.oop.project.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "question_mark_id")
    private QuestionMark questionMark;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "quizQuestion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();
}
