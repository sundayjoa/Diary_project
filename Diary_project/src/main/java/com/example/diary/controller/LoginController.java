package com.example.diary.controller;

import com.example.diary.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "password") String password,HttpSession session) {
        
        String name = loginService.getNameByIdAndPassword(id, password);
        if (name != null) {
        	//세션에 로그인 한 사람의 아이디와 이름 저장
        	session.setAttribute("userID", id);
            session.setAttribute("userName", name);
            return ResponseEntity.ok("로그인 성공");

        } else {
        	return ResponseEntity.ok("아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }
}