package com.in.onlinequiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.onlinequiz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}
