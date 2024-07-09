package com.example.diary.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

            return ExchangeService.saveMydiary(exchange);
            
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
    
    @DeleteMapping("/delete/{ExchangeNumber}")
    public ResponseEntity<String> deleteDiary(@PathVariable("ExchangeNumber") BigInteger exchageNumber, HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>("User not logged in", HttpStatus.UNAUTHORIZED);
        }
        
        ExchangeService.deleteExchange(exchageNumber);
        return new ResponseEntity<>("일기장이 삭제되었습니다.", HttpStatus.OK);
    }
    
    @PutMapping("/update/{ExchangeNumber}")
    public ResponseEntity<String> updateExchange(@PathVariable("ExchangeNumber") BigInteger exchangeNumber,
                                              @RequestParam("diaryTitle") String diaryTitle,
                                              @RequestParam("diaryContent") String diaryContent,
                                              HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        if (userId == null) {
            return new ResponseEntity<>("User not logged in", HttpStatus.UNAUTHORIZED);
        }

        Exchange exchange = ExchangeService.findByExchangeNumber(exchangeNumber);
        if (!exchange.getId().equals(userId)) {
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        }

        exchange.setTitle(diaryTitle);
        exchange.setContent(diaryContent);
        ExchangeService.saveExchange(exchange);

        return new ResponseEntity<>("수정이 완료되었습니다.", HttpStatus.OK);
    }
}