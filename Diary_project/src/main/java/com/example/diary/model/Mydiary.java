package com.example.diary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "my")
public class Mydiary {
	@Id
	@Column(name="DiaryNumber", columnDefinition = "BIGINT")
    private BigInteger DiaryNumber;
		
    @Column(name="ID", length = 30, nullable = false)
    private String id;
	
    @Lob
	@Column(name = "content")
    private String content;
    
    @Column(name = "date")
    private LocalDateTime date;
    
    @Column(name="weather", length = 100)
    private String weather;
    
    @Column(name = "`public`")
    private boolean isPublic;
    
    @Column(name = "`like`")
    private int likeCount;
	
	@Column(name = "Name", length = 50)
    private String name;
	
	
	public BigInteger getDiaryNumber() {
        return DiaryNumber;
    }

    public void setDiaryNumber(BigInteger DiaryNumber) {
        this.DiaryNumber = DiaryNumber;
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
    
	public String getWeather() {
        return id;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
    
    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}