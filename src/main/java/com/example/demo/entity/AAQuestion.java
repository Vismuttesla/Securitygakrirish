package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class AAQuestion extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AAAACategory AAAACategory;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private Long viewCount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<AAAATag> AAAATags;

}
