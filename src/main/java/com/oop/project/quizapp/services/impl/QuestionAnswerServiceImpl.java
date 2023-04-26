package com.oop.project.quizapp.services.impl;

import com.oop.project.quizapp.dto.ImportQA;
import com.oop.project.quizapp.dto.Pagination;
import com.oop.project.quizapp.dto.QuestionAnswerDto;
import com.oop.project.quizapp.dto.Question_AnswerDto;
import com.oop.project.quizapp.models.QuestionAnswer;
import com.oop.project.quizapp.models.Quiz;
import com.oop.project.quizapp.models.QuizQuestion;
import com.oop.project.quizapp.repositories.QuestionAnswerRepository;
import com.oop.project.quizapp.repositories.QuizQuestionRepository;
import com.oop.project.quizapp.repositories.QuizRepositories;
import com.oop.project.quizapp.services.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private QuizRepositories quizRepositories;
    @Override
    public List<Question_AnswerDto> findQuestionAnswerByQuizId(Long quizId){
        List<Question_AnswerDto> question_answerDtos = new ArrayList<>();
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findByQuizId(quizId);
        for (QuizQuestion question:
             quizQuestions) {

            List<QuestionAnswer> questionAnswers = questionAnswerRepository.findByQuizQuestionId(question.getId());
            List<QuestionAnswerDto> questionAnswerDtos = new ArrayList<>();
            for (QuestionAnswer answer :
                    questionAnswers) {
                QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto(
                        answer.getId(), answer.getDescription(), answer.getImgAnswer(), answer.isCorrect_answer(), answer.getScore()
                );
                questionAnswerDtos.add(questionAnswerDto);
            }
            Question_AnswerDto question_answerDto = new Question_AnswerDto(
                    question.getId(),question.getName(), question.getDescription(), question.getImgQuiz(),
                    new HashSet<>(questionAnswerDtos)
            );
            question_answerDtos.add(question_answerDto);
        }
        return question_answerDtos;
    }

    @Override
    public void createQA(List<ImportQA> importQAS, Long quizId) {
        Quiz quiz = quizRepositories.findById(quizId).orElseThrow(null);

        for (ImportQA importQA:
             importQAS) {
            QuizQuestion question = new QuizQuestion();
            question.setName(importQA.getName());
            question.setDescription(importQA.getDescription());
            question.setMark(importQA.getQuestion_mark());
            question.setImgQuiz(importQA.getImgQuestion());
            question.setQuiz(quiz);
            quiz.getQuizQuestions().add(question);

            QuizQuestion question1 = quizQuestionRepository.save(question);
            quizRepositories.save(quiz);

            for (QuestionAnswerDto answer :
                    importQA.getQuestionAnswerDtos()) {
                QuestionAnswer newAnswer = new QuestionAnswer();
                newAnswer.setDescription(answer.getDescription());
                newAnswer.setImgAnswer(answer.getImgAnswer());
                newAnswer.setCorrect_answer(answer.isCorrect_answer());
                newAnswer.setScore(answer.getScore());
                newAnswer.setQuizQuestion(question1);
                question1.getQuestionAnswers().add(newAnswer);

                questionAnswerRepository.save(newAnswer);

                quizQuestionRepository.save(question1);
            }
        }

    }

    @Override
    public void updateQA(Long questionId, ImportQA importQA) {
        QuizQuestion question = quizQuestionRepository.findById(questionId).orElseThrow(null);
        question.setName(importQA.getName());
        question.setDescription(importQA.getDescription());
        question.setImgQuiz(importQA.getImgQuestion());
        question.setMark(importQA.getQuestion_mark());

        for (QuestionAnswerDto answerDto : importQA.getQuestionAnswerDtos()) {
            if (answerDto.getId() != null) {
                // Update existing QuestionAnswer
                QuestionAnswer answer = questionAnswerRepository.findById(answerDto.getId())
                        .orElseThrow(null);
                answer.setDescription(answerDto.getDescription());
                answer.setImgAnswer(answerDto.getImgAnswer());
                answer.setCorrect_answer(answerDto.isCorrect_answer());
                answer.setScore(answerDto.getScore());
                answer.setQuizQuestion(question);
                questionAnswerRepository.save(answer);
            } else {
                // Create new QuestionAnswer
                QuestionAnswer answer = new QuestionAnswer();
                answer.setDescription(answerDto.getDescription());
                answer.setImgAnswer(answerDto.getImgAnswer());
                answer.setCorrect_answer(answerDto.isCorrect_answer());
                answer.setScore(answerDto.getScore());
                answer.setQuizQuestion(question);
                question.getQuestionAnswers().add(answer);
                questionAnswerRepository.save(answer);
            }
        }
        quizQuestionRepository.save(question);
    }

    @Override
    public List<Question_AnswerDto> findQASubCateByQuizId(Long quizId) {
        Quiz quiz = quizRepositories.findById(quizId).orElseThrow(null);
        return findQASubCate(quiz);
    }

    public List<Question_AnswerDto> findQASubCate(Quiz quiz) {
//        Quiz quiz = quizRepositories.findById(quizId).orElseThrow(null);
        List<Question_AnswerDto> question_answerDtos = new ArrayList<>();
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findByQuizId(quiz.getId());
        if(quizQuestions != null && !quizQuestions.isEmpty()){
            for (QuizQuestion question:
                    quizQuestions) {

                List<QuestionAnswer> questionAnswers = questionAnswerRepository.findByQuizQuestionId(question.getId());
                List<QuestionAnswerDto> questionAnswerDtos = new ArrayList<>();
                for (QuestionAnswer answer :
                        questionAnswers) {
                    QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto(
                            answer.getId(), answer.getDescription(), answer.getImgAnswer(), answer.isCorrect_answer(), answer.getScore()
                    );
                    questionAnswerDtos.add(questionAnswerDto);
                }
                Question_AnswerDto question_answerDto = new Question_AnswerDto(
                        question.getId(),question.getName(), question.getDescription(), question.getImgQuiz(),
                        new HashSet<>(questionAnswerDtos)
                );
                question_answerDtos.add(question_answerDto);
            }
        }
        List<Quiz> subQuiz = quizRepositories.findByParentId(quiz.getId());

        if(subQuiz != null && !subQuiz.isEmpty()){
            for (Quiz subquiz : subQuiz){
                System.out.println(subquiz.getName());
                List<Question_AnswerDto> subQuizList = findQASubCate(subquiz);
                if (subQuizList != null && !subQuizList.isEmpty()){
                    question_answerDtos.addAll(subQuizList);
                }
            }
        }
        return question_answerDtos;
    }
    @Override
    public Question_AnswerDto getQuestionById(Long ques_id){
        QuizQuestion question = quizQuestionRepository.findById(ques_id).orElseThrow(null);
        List<QuestionAnswer> questionAnswers = questionAnswerRepository.findByQuizQuestionId(ques_id).stream().toList();

        Question_AnswerDto question_answerDto = new Question_AnswerDto();

        question_answerDto.setId(question.getId());
        question_answerDto.setName(question.getName());
        question_answerDto.setDescription(question.getDescription());
        question_answerDto.setImgQuiz(question.getImgQuiz());
        List<QuestionAnswerDto> questionAnswerDtoList = new ArrayList<>();
        for (QuestionAnswer answer : questionAnswers){
            QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto(
                    answer.getId(), answer.getDescription(), answer.getImgAnswer(), answer.isCorrect_answer(), answer.getScore()
            );

            questionAnswerDtoList.add(questionAnswerDto);
        }
        question_answerDto.setQuestionAnswerSet(new HashSet<>(questionAnswerDtoList));
        return  question_answerDto;
    }

    @Override
    public List<Question_AnswerDto> QAwithPagination(Long quizId,Long pageNo, Long pageSize) {
        Pageable pageable = PageRequest.of(pageNo.intValue(), pageSize.intValue());

//List<QuizQuestion> quizQuestionList = quizQuestionRepository.findByQuizId(quizId,pageable).getContent().stream().toList();

        List<Question_AnswerDto> question_answerDtos =
                quizQuestionRepository.findByQuizId(quizId,pageable).getContent().stream().map(question -> mapToDTO(question)).collect(Collectors.toList());
        return question_answerDtos;
    }

    public Question_AnswerDto mapToDTO(QuizQuestion question){
        List<QuestionAnswer> answers = questionAnswerRepository.findByQuizQuestionId(question.getId());
        List<QuestionAnswerDto> questionAnswerDtoList = new ArrayList<>();
        for (QuestionAnswer answer :
                answers) {
            questionAnswerDtoList.add(
                    new QuestionAnswerDto(answer.getId(), answer.getDescription(),
                            answer.getImgAnswer(), answer.isCorrect_answer(), answer.getScore())
            );
        }
        return new Question_AnswerDto(
                question.getId(), question.getName(), question.getDescription(),
                question.getImgQuiz(), //new Set<>(question.getQuestionAnswers()
          new HashSet<> (questionAnswerDtoList)
        );
    }
}
