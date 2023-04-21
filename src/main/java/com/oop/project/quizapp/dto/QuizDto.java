package com.oop.project.quizapp.dto;


import com.oop.project.quizapp.models.Quiz;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizDto {
    private Long id;
    private String name;

    private String description;

    private Long parentID;
    private Quiz parent;

    private List<QuizDto> children = new ArrayList<>();

}
