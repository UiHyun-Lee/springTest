package com.example.practice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private Long id;

    @Column
    private String appendDate;

    @Column(unique = true)
    private String email;

    @Column
    private Long index;

    @Column
    private String name;

    @Column(unique = true)
    private String nickname;

    @Column
    private String password;

    @Column
    private String updateDate;

    @Column
    private String userAuth;
}