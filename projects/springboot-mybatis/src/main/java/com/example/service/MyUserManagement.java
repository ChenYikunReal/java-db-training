package com.example.service;

import com.example.pojo.MyUser;

import java.util.List;

public interface MyUserManagement {

    List<MyUser> selectById(int id);

}
