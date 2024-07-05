package com.example.diary.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.Like;
import com.example.diary.repository.LikeRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public boolean UserLiked(BigInteger diaryNumber, String id) {
        return likeRepository.findByDiaryNumberAndId(diaryNumber, id).isPresent();
    }
    
    public long getLikeCount(BigInteger diaryNumber) {
        return likeRepository.countByDiaryNumber(diaryNumber);
    }
    
    public void addLike(BigInteger diaryNumber, String userId) {
        Like like = new Like();
        like.setDiaryNumber(diaryNumber);
        like.setId(userId);
        likeRepository.save(like);
    }

    public void removeLike(BigInteger diaryNumber, String userId) {
        Optional<Like> like = likeRepository.findByDiaryNumberAndId(diaryNumber, userId);
        like.ifPresent(likeRepository::delete);
    }
}
