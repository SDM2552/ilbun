package com.orange.ilbun.model;

import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String address;
    private String role;
    private int point;


}
