package com.in.onlinequiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.Option;
import com.in.onlinequiz.model.Question;
import com.in.onlinequiz.repository.OptionRepository;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    public List<Option> getOptionsByQuestion(Question question) {
        return null;//optionRepository.findAll().stream().filter(o -> o.getQuestion().equals(question)).collect(Collectors.toList());
    }

    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }

	public Option create(Option option) {
		return optionRepository.save(option);
	}
}
