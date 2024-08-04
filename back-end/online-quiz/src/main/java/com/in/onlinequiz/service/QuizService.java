package com.in.onlinequiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.Quiz;
import com.in.onlinequiz.repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

	public List<Quiz> serach() {
		return quizRepository.findAll();
		
	}

	public Quiz create(Quiz quiz) {
		return quizRepository.save(quiz);
		
	}

	public Quiz findById(long id) {
		return quizRepository.findById(id).get();
	}
}
