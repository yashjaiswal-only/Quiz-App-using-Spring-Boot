package com.telusko.quizapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionMapping;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.service.QuestionService;
import com.telusko.quizapp.service.QuizService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create/{category}/{limit}")
    public List<QuestionMapping> createQuiz(@PathVariable String category, @RequestBody Quiz bodyQuiz, @PathVariable Integer limit){
        return quizService.createQuiz(category,bodyQuiz.getName(),limit);
    }

    @PostMapping("submit")
    public String ad(@RequestBody JsonNode body){
        System.out.println(body.get("answer"));
        body.get("answer").forEach(a->{
            System.out.println(a.get("questionId"));
            System.out.println(a.get("answer"));
        });

        return "SIb";
    }

}