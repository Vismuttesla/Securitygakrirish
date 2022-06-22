package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

//import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
public class AAAACategory extends BaseEntity {

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private AAAACategory parent;

    private String iconCode;
}
