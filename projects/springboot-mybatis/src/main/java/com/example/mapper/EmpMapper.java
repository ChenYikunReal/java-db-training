package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    Emp selectById(int id);

    List<Emp> selectByName(String name);

    void insertOne(Emp emp);

    void updateByName(Map<String, String> map);

    void deleteById(int id);

    void deleteByName(String name);

    List<Emp> selectSelective(Emp emp);

    void insertSelective(Emp emp);

    void updateSelective(Emp emp);

    void insertBatch(List<Emp> empList);

    void deleteBatch(List<Integer> empList);

}
