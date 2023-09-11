package com.example.backendsp2.service.impl;

import com.example.backendsp2.dto.PostsDTO;
import com.example.backendsp2.model.Posts;
import com.example.backendsp2.repository.IPostsRepository;
import com.example.backendsp2.service.IPostsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService implements IPostsService {
    @Autowired
    private IPostsRepository iPostsRepository;

    @Override
    public Page<PostsDTO> getAllPosts(Pageable pageable, String nameSearch) {
        List<PostsDTO> postsDTOList = new ArrayList<>();
        Page<Posts> postsPage = iPostsRepository.findPosts(pageable, nameSearch);
        PostsDTO postsDTO;
        for (Posts posts : postsPage) {
            postsDTO = new PostsDTO();
            BeanUtils.copyProperties(posts, postsDTO);
            postsDTOList.add(postsDTO);
        }
        return new PageImpl<>(postsDTOList, pageable, postsPage.getTotalElements());
    }
    @Override
    public Optional<Posts> findByIdPosts(Long id) {
        return iPostsRepository.findById(id);
    }
}
