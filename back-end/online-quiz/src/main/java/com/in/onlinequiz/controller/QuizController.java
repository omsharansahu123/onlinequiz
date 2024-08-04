package com.in.onlinequiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.onlinequiz.model.Quiz;
import com.in.onlinequiz.model.User;
import com.in.onlinequiz.service.QuizService;

@RestController
@RequestMapping("Quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@GetMapping("search")
	public List<Quiz> search(){
		return quizService.serach();
	}
	
	@PostMapping("create")
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.create(quiz);
	}
	
	@GetMapping("findById/{id}")
	public Quiz findById(@PathVariable long id) {
		return quizService.findById(id);
	}
}
