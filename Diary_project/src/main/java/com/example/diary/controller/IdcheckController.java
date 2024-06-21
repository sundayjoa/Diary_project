package com.example.diary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.service.IdcheckService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class IdcheckController {

    @Autowired
    private IdcheckService idcheckService;

    @GetMapping("/api/membership/check-id")
    public String checkId(@RequestParam("id") String id) {
        if (idcheckService.isIdAvailable(id)) {
            return "사용 가능한 ID입니다.";
        } else {
            return "이미 사용 중인 ID입니다.";
        }
    }
}