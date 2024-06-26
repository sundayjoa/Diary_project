package com.example.diary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.RcTopic;
import com.example.diary.repository.RcTopicRepository;

@Service
public class RcTopicService {

    @Autowired
    private RcTopicRepository rcTopicRepository;

    public RcTopic saveTopic(RcTopic rcTopic) {
        return rcTopicRepository.save(rcTopic);
    }
    
    public Optional<RcTopic> RandomTopic() {
        return rcTopicRepository.findRandomTopic();
    }
}