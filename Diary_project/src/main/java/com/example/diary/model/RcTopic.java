package com.example.diary.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topic")
public class RcTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Number", columnDefinition = "BIGINT")
    private BigInteger Number;
	
	@Column(name = "topic", length = 150)
    private String topic;
	
	public BigInteger getNumber() {
        return Number;
    }

    public void setNumber(BigInteger Number) {
        this.Number = Number;
    }
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}