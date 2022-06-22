package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class AAAATag extends BaseEntity {

    @Column(unique = true)
    private String title;
}
