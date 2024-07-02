package com.example.diary.controller;

import com.example.diary.model.Mydiary;
import com.example.diary.service.MydiaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/my_diary")
public class MydiaryController {

    @Autowired
    private MydiaryService MydiaryService;

    @PostMapping
    public Mydiary createDiary(@RequestParam("diaryTitle") String diaryTitle,
                             @RequestParam("diaryContent") String diaryContent,
                             @RequestParam("visibility") String visibility,
                             HttpSession session) {
        String userID = (String) session.getAttribute("userID");
        String userName = (String) session.getAttribute("userName");

        if (userID != null && userName != null) {
            Mydiary my_diary = new Mydiary();
            my_diary.setTitle(diaryTitle);
            my_diary.setContent(diaryContent);
            my_diary.setDate(LocalDateTime.now());
            my_diary.setIsPublic(visibility.equals("public"));
            my_diary.setLikeCount(0);
            my_diary.setName(userName);
            my_diary.setId(userID);

            return MydiaryService.saveMydiary(my_diary);
            
        } else {
            throw new RuntimeException("User not logged in.");
        }
    }
    
    @PostMapping("/posts")
    public List<Mydiary> getPosts(HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        System.out.println("Checking session for userID: " + userId);
        
        if (userId == null) {
            System.out.println("User is not logged in");
            return Collections.emptyList();
        }
        System.out.println("User ID: " + userId);
        List<Mydiary> posts = MydiaryService.getPostsById(userId);
        System.out.println("Number of posts found: " + posts.size());
        return posts;
    }
    
    @DeleteMapping("/delete/{DiaryNumber}")
    public ResponseEntity<String> deleteDiary(@PathVariable("DiaryNumber") BigInteger DiaryNumber, HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>("User not logged in", HttpStatus.UNAUTHORIZED);
        }
        
        MydiaryService.deleteDiary(DiaryNumber);
        return new ResponseEntity<>("일기장이 삭제되었습니다.", HttpStatus.OK);
    }
    
    @PutMapping("/update/{DiaryNumber}")
    public ResponseEntity<String> updateDiary(@PathVariable("DiaryNumber") BigInteger diaryNumber,
                                              @RequestParam("diaryTitle") String diaryTitle,
                                              @RequestParam("diaryContent") String diaryContent,
                                              @RequestParam("visibility") String visibility,
                                              HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>("User not logged in", HttpStatus.UNAUTHORIZED);
        }

        Mydiary my_diary = MydiaryService.findByDiaryNumber(diaryNumber);
        if (!my_diary.getId().equals(userId)) {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        }

        my_diary.setTitle(diaryTitle);
        my_diary.setContent(diaryContent);
        my_diary.setIsPublic(visibility.equals("public"));
        MydiaryService.saveMydiary(my_diary);

        return new ResponseEntity<>("수정이 완료되었습니다.", HttpStatus.OK);
    }
    

}
