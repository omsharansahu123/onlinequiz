package com.in.onlinequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.onlinequiz.model.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
