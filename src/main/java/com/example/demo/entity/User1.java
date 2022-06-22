package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="my_user")
@Getter
@Setter
public class User1 extends BaseEntity {
    @Column(unique = true)
    private String email;
    private String password;


    @Column(nullable = false)
    @ColumnDefault("fasle")
    private boolean confirmed = false;
    private String fullName;

    @Enumerated(EnumType.STRING)  // (EnumType.ORDINAL)==> DEGANI ENAMDAN SHU TARTIB NOMERLARNI OLADI DEGANI
    private UserRole role = UserRole.USER;

}
