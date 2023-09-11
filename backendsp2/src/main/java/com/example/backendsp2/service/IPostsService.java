package com.example.backendsp2.service;

import com.example.backendsp2.dto.PostsDTO;
import com.example.backendsp2.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostsService {
    Page<PostsDTO> getAllPosts (Pageable pageable, String nameSearch);
    Optional<Posts> findByIdPosts(Long id);
}
