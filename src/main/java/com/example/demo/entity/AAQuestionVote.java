package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class AAQuestionVote extends BaseEntity {
    @ManyToOne
    private AAQuestion AAQuestion;
}
