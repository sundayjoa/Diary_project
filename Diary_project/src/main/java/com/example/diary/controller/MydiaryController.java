package com.example.diary.controller;

import com.example.diary.model.Mydiary;
import com.example.diary.service.MydiaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;

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
}
