package com.telusko.quizapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionMapping;
import com.telusko.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public List<QuestionMapping> createQuiz(String category, String name,Integer limit) {
        List<Question> questions=questionDao.findByCategoryByLimit(category, limit);
        List<QuestionMapping> questionsToBeGiven=new ArrayList<>();
        questions.forEach(question -> {
            questionsToBeGiven.add(new QuestionMapping(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
        });

        Quiz quiz= new Quiz(name,questions);
        quizDao.save(quiz);
        return questionsToBeGiven;
    }


    public String createQuiz(JsonNode answers) {
        final Integer[] score = {0};
        answers.forEach(answer->{
            Integer qid=answer.get("questionId").asInt();
            Question question=questionDao.findById(qid).orElse(null);
            if(Objects.equals(question.getRightAnswer(), answer.get("response").asText())) score[0]++;
        });
        System.out.println(score[0]);
        return "Submitted , score: " + score[0].toString();
    }
}
