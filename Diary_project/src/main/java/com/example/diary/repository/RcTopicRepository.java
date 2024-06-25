package com.example.diary.repository;

import com.example.diary.model.RcTopic;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RcTopicRepository extends JpaRepository<RcTopic, BigInteger> {
	
	@Query(value = "SELECT * FROM topic ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<RcTopic> findRandomTopic();
	
}


