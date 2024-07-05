package com.example.diary.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.repository.LikeRepository;
import com.example.diary.service.LikeService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;
    
    @Autowired
    private LikeService likeService;

    //로그인 한 사람의 좋아요 여부 체크
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkUserLike(@RequestParam("DiaryNumber") BigInteger diaryNumber, HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }

        boolean isLiked = likeRepository.findByDiaryNumberAndId(diaryNumber, userId).isPresent();
        return new ResponseEntity<>(isLiked, HttpStatus.OK);
    }
    
    //게시글의 좋아요 수 가져오기
    @GetMapping("/count")
    public ResponseEntity<Long> getLikeCount(@RequestParam("DiaryNumber") BigInteger diaryNumber) {
        long likeCount = likeService.getLikeCount(diaryNumber);
        return new ResponseEntity<>(likeCount, HttpStatus.OK);
    }
    
    //좋아요 기능
    @PostMapping("/toggle")
    public ResponseEntity<String> toggleLike(@RequestParam("DiaryNumber") BigInteger diaryNumber, HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>("로그인이 되어 있지 않습니다.", HttpStatus.UNAUTHORIZED);
        }

        if (likeService.UserLiked(diaryNumber, userId)) {
            likeService.removeLike(diaryNumber, userId);
            return new ResponseEntity<>("좋아요 삭제", HttpStatus.OK);
        } else {
            likeService.addLike(diaryNumber, userId);
            return new ResponseEntity<>("좋아요 추가", HttpStatus.OK);
        }
    }
}
