package com.in.onlinequiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.onlinequiz.model.Question;
import com.in.onlinequiz.model.QuizAttempt;
import com.in.onlinequiz.model.UserAnswer;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

	List<UserAnswer> findByQuizAttemptAndQuestion(QuizAttempt quizAttempt, Question question);

	List<UserAnswer> findByQuizAttempt(QuizAttempt quizAttempt);
}
