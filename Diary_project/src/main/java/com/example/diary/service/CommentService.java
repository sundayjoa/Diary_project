package com.example.diary.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.Comment;
import com.example.diary.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository CommentRepository;

    public Comment saveComment(Comment comment) {
        return CommentRepository.save(comment);
    }
    
    public List<Comment> getAllposts() {
        return CommentRepository.findAll();
    }
    
    //교환일기 가져오기
    public List<Comment> getPostsByExchangeNumber(Long exchangeNumber) {
        List<Comment> posts = new ArrayList<>();

        List<Comment> comments = CommentRepository.findByExchangeNumberOrderByDateAsc(exchangeNumber);
        for (Comment comment : comments) {
            posts.add(comment);
        }

        return posts;
    }
}