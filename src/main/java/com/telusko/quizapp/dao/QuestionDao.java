package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    List<Question> findByDifficultylevel(String level);

    @Query(value="SELECT * from question  WHERE category=:category ORDER BY random() LIMIT :limit",nativeQuery = true)
    List<Question> findByCategoryByLimit(String category,Integer limit);
}
