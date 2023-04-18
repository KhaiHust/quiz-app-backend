package com.oop.project.quizapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponeObject {
    private String status;
    private String message;
    private Object data;
}
