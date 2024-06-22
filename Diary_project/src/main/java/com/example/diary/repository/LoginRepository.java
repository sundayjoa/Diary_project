package com.example.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.diary.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    boolean existsById(String id);
    boolean existsByPassword(String password);
    
    @Query("SELECT l.password FROM Login l WHERE l.id = :id")
    String getPasswordById(@Param("id") String id);

    @Query("SELECT l.name FROM Login l WHERE l.id = :id AND l.password = :password")
    String findNameByIdAndPassword(@Param("id") String id, @Param("password") String password);
}