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
	
}