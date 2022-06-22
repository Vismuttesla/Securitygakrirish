package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedDate = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User1 createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User1 lastModifiedBy;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean deleted = false;

}
