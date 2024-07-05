package com.example.diary.repository;

import com.example.diary.model.Mydiary;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MydiaryRepository extends JpaRepository<Mydiary, BigInteger> {
	List<Mydiary> findById(String id);
	
	//공개 게시글 최신 4개
	List<Mydiary> findTop4ByIsPublicOrderByDateDesc(boolean isPublic);
	
	//공개 게시글 전체
	List<Mydiary> findByIsPublicOrderByDateDesc(boolean isPublic);
	
}