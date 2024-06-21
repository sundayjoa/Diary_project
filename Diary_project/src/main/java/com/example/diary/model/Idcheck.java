package com.example.diary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership")
public class Idcheck {
	@Id
    @Column(length = 30, nullable = false)
    private String id;
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}