package com.in.onlinequiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.onlinequiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	List<Question> findByQuizId(Long quizId);
}
