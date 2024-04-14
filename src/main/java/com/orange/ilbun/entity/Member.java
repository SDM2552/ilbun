package com.orange.ilbun.entity;

import com.orange.ilbun.constant.Role;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String address;
    private int point = 0;
    @Enumerated(EnumType.STRING)
    private Role role;

}
