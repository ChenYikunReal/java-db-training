package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {

    private int id;

    private String username;

    private String password;

    private Role role;

    private int role_id;

}
