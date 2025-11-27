package com.everytime.domain.post.repository;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.QPost;
import com.everytime.domain.post.domain.enums.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private static final QPost post = QPost.post;

    @Override
    public List<Post> findLatest4PostsByCategory(Category category) {
        return jpaQueryFactory
                .selectFrom(post)
                .where(post.category.eq(category))
                .orderBy(post.createdAt.desc())
                .limit(4)
                .fetch();
    }

    @Override
    public Optional<Post> findTopRealtimePopularPost() {
        Post result = jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.likeCount.desc(), post.createdAt.desc())
                .limit(1)
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public List<Post> findTop4PopularPosts() {
        return jpaQueryFactory
                .selectFrom(post)
                .orderBy(
                        post.likeCount.desc(), post.createdAt.desc()
                )
                .limit(4)
                .fetch();
    }
}
