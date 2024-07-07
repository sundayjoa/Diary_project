package com.example.diary.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange")
public class Exchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ExchangeNumber", columnDefinition = "BIGINT")
    private BigInteger exchangeNumber;
		
    @Column(name="ID", length = 30, nullable = false)
    private String id;
    
    @Column(name="title", length = 320)
    private String title;
	
    @Lob
	@Column(name = "content")
    private String content;
    
    @Column(name = "date")
    private LocalDateTime date;
	
	@Column(name = "Name", length = 50)
    private String name;
	
	
	public BigInteger getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(BigInteger exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
	
	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
	public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}