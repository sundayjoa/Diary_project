package com.example.diary.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.model.Comment;
import com.example.diary.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService CommentService;

    @PostMapping
    public Comment createDiary(@RequestParam("joinTitle") String joinTitle,
                             @RequestParam("joinContent") String joinContent,
                             @RequestParam("ExchangeNumber") Long exchangeNumber,
                             HttpSession session) {
        String userID = (String) session.getAttribute("userID");
        String userName = (String) session.getAttribute("userName");

        if (userID != null && userName != null) {
        	Comment comment = new Comment();
        	comment.setTitle(joinTitle);
        	comment.setContent(joinContent);
        	comment.setExchangeNumber(exchangeNumber);
        	comment.setDate(LocalDateTime.now());
        	comment.setName(userName);
        	comment.setId(userID);

            return CommentService.saveComment(comment);
            
        } else {
            throw new RuntimeException("User not logged in.");
        }
    }
}