package com.example.backendsp2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "DATETIME DEFAULT now()")
    private LocalDateTime createDate;

    public Posts() {
    }

    public Posts(Long id, String title, String image, String content, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}