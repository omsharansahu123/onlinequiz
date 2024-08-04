package com.in.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.onlinequiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
	