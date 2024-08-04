package com.in.onlinequiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.onlinequiz.model.QuizAttempt;
import com.in.onlinequiz.model.UserAnswer;
import com.in.onlinequiz.service.QuizAttemptService;

@RestController
@RequestMapping("QuizAttempt")
@CrossOrigin("*")
public class QuizAttemptController {
	
	@Autowired
	private QuizAttemptService quizAttemptService;

	@PostMapping("update")
	public QuizAttempt update(@RequestBody QuizAttempt quizAttempt) {
		return quizAttemptService.update(quizAttempt);
	}
	
	/**
	 * 
	 * @param request it's contain quizAttemptId and questionId
	 * @return
	 */
	@PostMapping("updateResult")
	public QuizAttempt updateResult(@RequestBody UserAnswer userAnswer) {
		return quizAttemptService.updateResult(userAnswer);
	}
	
	@GetMapping("findById/{id}")
	public QuizAttempt findByQuizId(@PathVariable long id){
		return quizAttemptService.findById(id);
	}
	
}
