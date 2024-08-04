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

import com.in.onlinequiz.model.Question;
import com.in.onlinequiz.service.QuestionService;

@RestController
@RequestMapping("Question")
@CrossOrigin("*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@GetMapping("findByQuizId/{quizId}")
	public List<Question> findByQuizId(@PathVariable long quizId){
		return questionService.findByQuizId(quizId);
	}
	
	@PostMapping("create")
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
}
