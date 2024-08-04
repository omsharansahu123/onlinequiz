package com.in.onlinequiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.Question;
import com.in.onlinequiz.model.QuizAttempt;
import com.in.onlinequiz.model.UserAnswer;
import com.in.onlinequiz.repository.UserAnswerRepository;

@Service
public class UserAnswerService {
	
	@Autowired
	private UserAnswerRepository answerRepository;

	public UserAnswer update(UserAnswer userAnswer) {

		List<UserAnswer> answers = answerRepository.findByQuizAttemptAndQuestion(userAnswer.getQuizAttempt(),userAnswer.getQuestion());
		
		if(answers.size()>=1) {
			UserAnswer oldAns = answers.get(0);
			oldAns.setSelectedOption(userAnswer.getSelectedOption());
			oldAns.setIsCorrect(userAnswer.getIsCorrect());
			return answerRepository.save(oldAns);
		}
		return answerRepository.save(userAnswer);
	}

	public List<UserAnswer> findByQuizAttempt(QuizAttempt quizAttempt) {
		
		return answerRepository.findByQuizAttempt(quizAttempt);
		
	}


}
