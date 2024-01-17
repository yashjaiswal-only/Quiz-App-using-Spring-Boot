package com.telusko.quizapp.service;

import com.telusko.quizapp.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        return String.valueOf(questionDao.save(question));
    }

    public String updateQuestion(Question question) {
        return String.valueOf(questionDao.save(question));
    }

    public String deleteQuestionById(String id) {
        questionDao.deleteById(Integer.valueOf(id));
        return "deleted";
    }
}
