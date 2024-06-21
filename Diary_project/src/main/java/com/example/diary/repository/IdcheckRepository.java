package com.example.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary.model.Idcheck;

@Repository
public interface IdcheckRepository extends JpaRepository<Idcheck, String> {
    boolean existsById(String id);
}