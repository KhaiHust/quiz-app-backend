package com.oop.project.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(ExamQuestionId.class)
public class ExamQuestion implements Serializable {
    @EmbeddedId
    private ExamQuestionId id;
    @Id
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private  Exam exam;

    @Id
    @ManyToOne
    @JoinColumn(name = "quizQuestion_id")
    private QuizQuestion question;
}
