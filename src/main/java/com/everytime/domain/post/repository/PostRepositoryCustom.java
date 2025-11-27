package com.everytime.domain.post.repository;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;

import java.util.List;
import java.util.Optional;

public interface PostRepositoryCustom {
    List<Post> findTop4ByCategoryOrderByCreatedAtDesc(Category category);

    Optional<Post> findTopByOrderByLikeCountDescCreatedAtDesc();

    List<Post> findTop4ByOrderByLikeCountDescCreatedAtDesc();
}
