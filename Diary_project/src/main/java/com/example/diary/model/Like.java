package com.example.diary.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "`like`")
public class Like {
	@Id
	@Column(name="DiaryNumber", columnDefinition = "BIGINT")
    private BigInteger diaryNumber;
	
	@Column(name="ID", length = 30, nullable = false)
    private String id;
	
	
	public BigInteger getDiaryNumber() {
        return diaryNumber;
    }

	public void setDiaryNumber(BigInteger DiaryNumber) {
        this.diaryNumber = DiaryNumber;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}