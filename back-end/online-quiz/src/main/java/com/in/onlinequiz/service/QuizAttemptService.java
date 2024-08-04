package com.in.onlinequiz.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.QuizAttempt;
import com.in.onlinequiz.model.User;
import com.in.onlinequiz.model.UserAnswer;
import com.in.onlinequiz.repository.QuizAttemptRepository;

@Service
public class QuizAttemptService {
	@Autowired
	private QuizAttemptRepository quizAttemptRepository;

	@Autowired
	private UserAnswerService userAnswerService;

	public QuizAttempt saveQuizAttempt(QuizAttempt quizAttempt) {
		return quizAttemptRepository.save(quizAttempt);
	}

	public List<QuizAttempt> getQuizAttemptsByUser(User user) {
		return quizAttemptRepository.findAll().stream().filter(qa -> qa.getUser().equals(user))
				.collect(Collectors.toList());
	}

	public QuizAttempt update(QuizAttempt quizAttempt) {
		quizAttempt.setAttemptDate(LocalDateTime.now());
		List<QuizAttempt> quizAttempt2 = quizAttemptRepository.findByUserAndQuiz(quizAttempt.getUser(),
				quizAttempt.getQuiz());
		if (quizAttempt2.size() <= 0) {
			return quizAttemptRepository.save(quizAttempt);
		}
		return quizAttempt2.get(0);

	}

	public QuizAttempt updateResult(UserAnswer userAnswer) {
		List<UserAnswer> answers = userAnswerService.findByQuizAttempt(userAnswer.getQuizAttempt());

		int conrrectAns = answers.stream().filter(ans -> ans.getIsCorrect()).toList().size();
		int totalOptions = answers.size();

		int percentage = (conrrectAns * 100) / totalOptions;

		QuizAttempt quizAttempt = quizAttemptRepository.findById(userAnswer.getQuizAttempt().getId()).get();
		quizAttempt.setScore(percentage);
		quizAttemptRepository.save(quizAttempt);
		return quizAttempt;
	}

	public QuizAttempt findById(long id) {
		return quizAttemptRepository.findById(id).get();
	}
}
