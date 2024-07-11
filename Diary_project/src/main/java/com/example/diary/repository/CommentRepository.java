package com.example.diary.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
	List<Comment> findByExchangeNumberOrderByDateAsc(Long exchangeNumber);
}