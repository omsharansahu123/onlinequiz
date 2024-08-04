package com.in.onlinequiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.onlinequiz.model.Quiz;
import com.in.onlinequiz.model.QuizAttempt;
import com.in.onlinequiz.model.User;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

	List<QuizAttempt> findByUserAndQuiz(User user, Quiz quiz);
}
