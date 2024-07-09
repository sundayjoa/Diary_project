package com.example.diary.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.Exchange;
import com.example.diary.repository.ExchangeRepository;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository ExchangeRepository;

    public Exchange saveMydiary(Exchange Exchange) {
        return ExchangeRepository.save(Exchange);
    }
    
    public List<Exchange> getAllposts() {
        return ExchangeRepository.findAll();
    }

    public void saveExchange(Exchange exchange) {
    	ExchangeRepository.save(exchange);
    }
    
    public void deleteExchange(BigInteger exchangeNumber) {
        Optional<Exchange> exchange = ExchangeRepository.findById(exchangeNumber);
        if (exchange.isPresent()) {
        	ExchangeRepository.delete(exchange.get());
        } else {
            throw new RuntimeException("Diary not found or not authorized to delete");
        }
    }
    
    public Exchange findByExchangeNumber(BigInteger exchangeNumber) {
        return ExchangeRepository.findById(exchangeNumber)
                .orElseThrow(() -> new RuntimeException("Diary not found"));
    }
}