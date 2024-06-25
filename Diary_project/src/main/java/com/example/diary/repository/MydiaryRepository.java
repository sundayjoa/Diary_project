package com.example.diary.repository;

import com.example.diary.model.Mydiary;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MydiaryRepository extends JpaRepository<Mydiary, BigInteger> {
}