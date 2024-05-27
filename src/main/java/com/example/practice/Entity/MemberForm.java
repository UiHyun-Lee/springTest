package com.example.practice.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    private String email;

    private String name;

    private String password;

    private String nickname;

    private String jwt;
}