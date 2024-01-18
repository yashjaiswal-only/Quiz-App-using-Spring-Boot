package com.telusko.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class QuestionMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionMapping(Integer id,String questionTitle, String option1, String option2, String option3, String option4){
        super();
        this.questionTitle=questionTitle;
        this.id=id;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
    }

    public void show() {
        System.out.println(questionTitle);
    }
}
