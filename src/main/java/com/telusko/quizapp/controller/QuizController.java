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
import java.util.List;

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
    public String createQuiz(@RequestBody JsonNode body){
        return quizService.createQuiz(body.get("answers"));
    }

}