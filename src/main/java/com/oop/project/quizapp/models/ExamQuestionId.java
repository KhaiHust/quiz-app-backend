package com.oop.project.quizapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ExamQuestionId implements Serializable {
//    @Column(name = "exam_id")
    private Long exam;

//    @Column(name = "quizQuestion_id")
    private Long question;
}
