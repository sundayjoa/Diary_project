package com.example.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.Idcheck;
import com.example.diary.repository.IdcheckRepository;

@Service
public class IdcheckService {

    @Autowired
    private IdcheckRepository IdcheckRepository;

    public boolean isIdAvailable(String id) {
        return !IdcheckRepository.existsById(id);
    }

    public void register(Idcheck idcheck) {
    	IdcheckRepository.save(idcheck);
    }
}