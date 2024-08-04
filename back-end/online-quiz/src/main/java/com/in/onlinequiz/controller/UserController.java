package com.in.onlinequiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.onlinequiz.model.User;
import com.in.onlinequiz.service.UserService;

@RestController
@RequestMapping("User")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("create")
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping("findById/{id}")
	public User findById(@PathVariable long id) {
		return userService.findById(id);
	}
	
	@PostMapping("login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}
}
