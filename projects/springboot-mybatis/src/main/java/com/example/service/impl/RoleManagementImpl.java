package com.example.service.impl;

import com.example.mapper.RoleMapper;
import com.example.pojo.Role;
import com.example.service.RoleManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManagementImpl implements RoleManagement {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectById(int id) {
        return roleMapper.selectById(id);
    }

}
