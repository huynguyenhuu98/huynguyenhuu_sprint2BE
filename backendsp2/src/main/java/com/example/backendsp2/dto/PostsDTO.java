package com.example.backendsp2.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class PostsDTO {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private LocalDateTime createDate;
    @NotBlank
    private String image;

    public PostsDTO() {
    }

    public PostsDTO(Long id, String title, String content, LocalDateTime createDate, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
