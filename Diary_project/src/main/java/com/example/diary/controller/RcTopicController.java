package com.example.diary.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.model.RcTopic;
import com.example.diary.service.RcTopicService;

@RestController
@RequestMapping("/api/topic")
public class RcTopicController {

    @Autowired
    private RcTopicService rcTopicService;

    @PostMapping("/add")
    public RcTopic addTopic(@RequestBody RcTopic rcTopic) {
        return rcTopicService.saveTopic(rcTopic);
    }
    
    @GetMapping("/random")
    public RcTopic RandomTopic() {
        Optional<RcTopic> randomTopic = rcTopicService.RandomTopic();
        return randomTopic.orElseThrow(() -> new RuntimeException("주제를 찾을 수 없습니다."));
    }
    
}