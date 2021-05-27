package com.example.service;

import com.example.pojo.Role;

import java.util.List;

public interface RoleManagement {

    List<Role> selectById(int id);

}
