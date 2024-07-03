package com.example.diary.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary.model.Like;

public interface LikeRepository extends JpaRepository<Like, BigInteger> {
    Optional<Like> findByDiaryNumberAndId(BigInteger diaryNumber, String id);
}
