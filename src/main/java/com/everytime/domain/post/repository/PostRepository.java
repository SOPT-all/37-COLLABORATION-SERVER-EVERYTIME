package com.everytime.domain.post.repository;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop4ByCategoryOrderByCreatedAtDesc(Category category);
    Optional<Post> findTopByOrderByLikeCountDescCreatedAtDesc();
    List<Post> findTop4ByOrderByLikeCountDescCreatedAtDesc();
}
