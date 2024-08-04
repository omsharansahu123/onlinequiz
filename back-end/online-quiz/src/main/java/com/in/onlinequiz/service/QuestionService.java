package com.in.onlinequiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.Question;
import com.in.onlinequiz.model.Quiz;
import com.in.onlinequiz.repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByQuiz(Quiz quiz) {
        return questionRepository.findAll().stream().filter(q -> q.getQuiz().equals(quiz)).collect(Collectors.toList());
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
    
    public List<Question> findByQuizId(long quizId){
    	return questionRepository.findByQuizId(quizId);
    }

	public Question create(Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}
}
