package com.example.diary.service;

import com.example.diary.model.Mydiary;
import com.example.diary.repository.MydiaryRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MydiaryService {

    @Autowired
    private MydiaryRepository MydiaryRepository;

    public Mydiary saveMydiary(Mydiary Mydiary) {
        return MydiaryRepository.save(Mydiary);
    }
    
    public List<Mydiary> getPostsById(String id) {
        List<Mydiary> posts = MydiaryRepository.findById(id);
        System.out.println("Retrieved posts from repository: " + posts);
        return posts;
    }

    public void saveDiary(Mydiary diary) {
        MydiaryRepository.save(diary);
    }
    
    public void deleteDiary(BigInteger DiaryNumber) {
        Optional<Mydiary> diary = MydiaryRepository.findById(DiaryNumber);
        if (diary.isPresent()) {
            MydiaryRepository.delete(diary.get());
        } else {
            throw new RuntimeException("Diary not found or not authorized to delete");
        }
    }
}