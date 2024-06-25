package com.example.diary.service;

import com.example.diary.model.Mydiary;
import com.example.diary.repository.MydiaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MydiaryService {

    @Autowired
    private MydiaryRepository MydiaryRepository;

    public Mydiary saveMydiary(Mydiary Mydiary) {
        return MydiaryRepository.save(Mydiary);
    }
}