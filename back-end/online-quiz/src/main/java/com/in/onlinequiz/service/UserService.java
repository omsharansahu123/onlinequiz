package com.in.onlinequiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.onlinequiz.model.User;
import com.in.onlinequiz.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		User userByMail = userRepository.findByEmail(user.getEmail());
		if(userByMail == null) {
			throw new RuntimeException("User with "+user.getEmail()+" not exist, Please SignUp");
		}
		User userData = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(userData == null) {
			throw new RuntimeException("Invalid password, Please enter valid password");
		}
		return userData;
	}
}
