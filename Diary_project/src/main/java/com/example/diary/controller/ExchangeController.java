package com.example.diary.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.model.Exchange;
import com.example.diary.service.ExchangeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/Exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService ExchangeService;

    @PostMapping
    public Exchange createDiary(@RequestParam("diaryTitle") String diaryTitle,
                             @RequestParam("diaryContent") String diaryContent,
                             HttpSession session) {
        String userID = (String) session.getAttribute("userID");
        String userName = (String) session.getAttribute("userName");

        if (userID != null && userName != null) {
        	Exchange exchange = new Exchange();
        	exchange.setTitle(diaryTitle);
        	exchange.setContent(diaryContent);
        	exchange.setDate(LocalDateTime.now());
        	exchange.setName(userName);
        	exchange.setId(userID);

            return ExchangeService.saveExchange(exchange);
            
        } else {
            throw new RuntimeException("User not logged in.");
        }
    }
    
    @PostMapping("/posts")
    public List<Exchange> getPosts(HttpSession session) {
        
        List<Exchange> posts = ExchangeService.getAllposts();
        System.out.println("Number of posts found: " + posts.size());
        return posts;
    }
    
}