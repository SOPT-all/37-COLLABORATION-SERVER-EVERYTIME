package com.everytime.domain.review.domain;

import com.everytime.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private String lecture;

    @Column(nullable = false)
    private String professor;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
