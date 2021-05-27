package com.example.service.impl;

import com.example.mapper.MyUserMapper;
import com.example.pojo.MyUser;
import com.example.service.MyUserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserManagementImpl implements MyUserManagement {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public List<MyUser> selectById(int id) {
        return myUserMapper.selectById(id);
    }

}
