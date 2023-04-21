package com.oop.project.quizapp.dto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.QuizQuestion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Question_AnswerDto {
    private Long id;
    private String name;
    private String description;
    private String imgQuiz;
    private Set<QuestionAnswerDto> questionAnswerSet;


//    public static Question_AnswerDto fromEntity(QuizQuestion quizQuestion){
//        Question_AnswerDto question_answerDto = new Question_AnswerDto();
//        question_answerDto.setId(quizQuestion.getId());
//        question_answerDto.setDescription(quizQuestion.getDescription());
//        question_answerDto.setImgQuiz(quizQuestion.getImgQuiz());
//        Set<QuestionAnswerDto> questionAnswerDtoSet = new HashSet<>();
//        for (QuestionAnswer questionAnswer : quizQuestion.getQuestionAnswers()){
//            QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
//            questionAnswerDto.setId(questionAnswer.getId());
//            questionAnswerDto.setDescription(questionAnswer.getDescription());
//            questionAnswerDto.setImgAnswer(questionAnswer.getImgAnswer());
//            questionAnswerDto.setCorrect_answer(questionAnswer.isCorrect_answer());
//            questionAnswerDto.setScore(questionAnswer.getScore());
//
//            questionAnswerDtoSet.add(questionAnswerDto);
//        }
//        question_answerDto.setQuestionAnswerSet(questionAnswerDtoSet);
//        return question_answerDto;
//    }
}
