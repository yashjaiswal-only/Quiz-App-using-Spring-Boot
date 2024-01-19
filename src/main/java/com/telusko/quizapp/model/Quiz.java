package com.telusko.quizapp.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    private List<Question> question;

    public Quiz(String name,List<Question> question){
        super();
        this.name=name;
        this.question=question;
    }

}
