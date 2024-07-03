package com.example.diary.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.repository.LikeRepository;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkUserLike(@RequestParam("DiaryNumber") BigInteger diaryNumber, HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }

        boolean isLiked = likeRepository.findByDiaryNumberAndId(diaryNumber, userId).isPresent();
        return new ResponseEntity<>(isLiked, HttpStatus.OK);
    }
}