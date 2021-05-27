package com.example.mapper;

import com.example.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyUserMapper {

    List<MyUser> selectById(int id);

}
