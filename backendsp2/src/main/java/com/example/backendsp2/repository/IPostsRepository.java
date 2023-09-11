package com.example.backendsp2.repository;

import com.example.backendsp2.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPostsRepository extends JpaRepository<Posts,Long> {
    @Query(value = "select * from posts where title like concat('%', :nameSearch, '%')", nativeQuery = true)
    Page<Posts> findPosts(Pageable pageable, @Param("nameSearch") String nameSearch);
    @Query(value = "select * from posts where posts.id = ?", nativeQuery = true)
    Optional<Posts> findById(Long id);
}
