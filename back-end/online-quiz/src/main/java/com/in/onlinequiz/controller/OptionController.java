package com.in.onlinequiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.onlinequiz.model.Option;
import com.in.onlinequiz.service.OptionService;

@RestController
@RequestMapping("Option")
@CrossOrigin("*")
public class OptionController {

	@Autowired
	private OptionService optionService;

	@PostMapping("create")
	public Option create(@RequestBody Option option) {
		return optionService.create(option);
	}
}
