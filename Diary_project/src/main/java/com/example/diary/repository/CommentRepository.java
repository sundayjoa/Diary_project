package com.example.diary.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
	
}