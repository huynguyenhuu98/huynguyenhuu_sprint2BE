package com.example.backendsp2.controllers;

import com.example.backendsp2.dto.PostsDTO;
import com.example.backendsp2.model.Posts;
import com.example.backendsp2.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostsController {
    @Autowired
    private IPostsService iPostsService;
    @GetMapping("")
    public ResponseEntity<Page<PostsDTO>> getPosts (@PageableDefault (sort = "title",direction = Sort.Direction.ASC) Pageable pageable,
    @RequestParam(required = false, defaultValue = "") String nameSearch){
        Page<PostsDTO> postsDTOS = iPostsService.getAllPosts(pageable, nameSearch);
        if (postsDTOS.isEmpty() && postsDTOS == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(postsDTOS, HttpStatus.OK);
    }
    @GetMapping("detailPosts/{id}")
    public ResponseEntity<Posts> detailPosts(@PathVariable Long id) {
        Optional<Posts> posts = iPostsService.findByIdPosts(id);
        if (!posts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts.get(), HttpStatus.OK);
    }
}
