package com.example.diary.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.repository.LikeRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public boolean UserLiked(BigInteger diaryNumber, String id) {
        return likeRepository.findByDiaryNumberAndId(diaryNumber, id).isPresent();
    }
}
