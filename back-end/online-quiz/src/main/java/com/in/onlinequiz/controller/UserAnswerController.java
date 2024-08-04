package com.in.onlinequiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.onlinequiz.model.UserAnswer;
import com.in.onlinequiz.service.UserAnswerService;

@RestController
@RequestMapping("UserAnswer")
@CrossOrigin("*")
public class UserAnswerController {

	@Autowired
	private UserAnswerService userAnswerService;

	@PostMapping("update")
	public UserAnswer update(@RequestBody UserAnswer userAnswer) {
		return userAnswerService.update(userAnswer);
	}
	
}
