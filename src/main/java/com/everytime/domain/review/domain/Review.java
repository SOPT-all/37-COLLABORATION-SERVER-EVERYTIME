package com.everytime.domain.review.domain;

import com.everytime.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private String lecture;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
