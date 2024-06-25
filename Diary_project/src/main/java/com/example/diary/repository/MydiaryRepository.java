package com.example.diary.repository;

import com.example.diary.model.Mydiary;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MydiaryRepository extends JpaRepository<Mydiary, BigInteger> {
	List<Mydiary> findById(String id);
}