package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AAQuestion AAQuestion;


    @Column(columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private Long viewCount = 0L;


}
