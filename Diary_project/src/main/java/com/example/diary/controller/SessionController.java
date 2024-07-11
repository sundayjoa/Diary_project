package com.example.diary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @GetMapping("/userinfo")
    public ResponseEntity<Map<String, String>> getUserInfo(HttpSession session) {
        String userId = (String) session.getAttribute("userID");
        String userName = (String) session.getAttribute("userName");

        if (userId != null && userName != null) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("userID", userId);
            userInfo.put("userName", userName);
            return ResponseEntity.ok(userInfo);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}