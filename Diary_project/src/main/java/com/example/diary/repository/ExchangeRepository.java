package com.example.diary.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, BigInteger> {
	Exchange findByExchangeNumber(Long exchangeNumber);
}