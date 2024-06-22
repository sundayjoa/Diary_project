package com.example.diary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership")
public class Login {
	@Id
    @Column(length = 30, nullable = false)
    private String id;
	
	@Column(name = "Password", length = 50)
    private String password;
	
	@Column(name = "Name", length = 50)
    private String name;
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}