package com.example.diary.repository;

import com.example.diary.model.RcTopic;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RcTopicRepository extends JpaRepository<RcTopic, BigInteger> {
}
