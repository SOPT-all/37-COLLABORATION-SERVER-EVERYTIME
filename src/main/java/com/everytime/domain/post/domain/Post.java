package com.everytime.domain.post.domain;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    private int likeCount;
    private int commentCount;
    @Column(nullable = false)
    private boolean isAnonymous;
    @Column(nullable = false, length = 50)
    private String nickname;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Category category;
}
