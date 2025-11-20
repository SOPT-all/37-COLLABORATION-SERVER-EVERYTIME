package com.everytime.domain.post.repository;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostSearchRepository extends JpaRepository<Post, Long> {

    // 특정 카테고리 내 검색
    @Query("""
    SELECT p FROM Post p
    WHERE p.category = :category
      AND (
            LOWER(p.title)   LIKE LOWER(CONCAT('%', :keyword, '%'))
         OR LOWER(p.content) LIKE LOWER(CONCAT('%', :keyword, '%'))
      )
""")
    Page<Post> searchPosts(
            @Param("category") Category category,
            @Param("keyword") String keyword,
            Pageable pageable
    );

    // 전체 카테고리 대상 검색 (ALL)
    @Query("""
        SELECT p FROM Post p
        WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(p.content) LIKE LOWER(CONCAT('%', :keyword, '%'))
        """)
    Page<Post> searchAll(
            @Param("keyword") String keyword,
            Pageable pageable
    );
}

