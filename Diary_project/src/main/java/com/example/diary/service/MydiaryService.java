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
    
    public Mydiary findByDiaryNumber(BigInteger diaryNumber) {
        return MydiaryRepository.findById(diaryNumber)
                .orElseThrow(() -> new RuntimeException("Diary not found"));
    }
    
    //내 게시글 최신 4개만 가져오기
    public List<Mydiary> getTop4PostsById(String id) {
        List<Mydiary> posts = MydiaryRepository.findTop4ByidOrderByDateDesc(id);
        return posts;
    }
   
    //공개 게시글 최신 4개만 가져오기
    public List<Mydiary> getTop4PublicPosts() {
        return MydiaryRepository.findTop4ByIsPublicOrderByDateDesc(true);
    }
    
    //공개 게시글 저체 가져오기
    public List<Mydiary> getPublicPosts(){
    	return MydiaryRepository.findByIsPublicOrderByDateDesc(true);
    }
}