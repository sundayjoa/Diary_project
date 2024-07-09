package com.example.diary.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, BigInteger> {
	
}