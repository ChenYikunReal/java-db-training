package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.service.EmpManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpManagementImpl implements EmpManagement {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp selectById(int id) {
        return empMapper.selectById(id);
    }

    @Override
    public List<Emp> selectByName(String name) {
        return empMapper.selectByName(name);
    }

    @Override
    public void insertOne(Emp emp) {
        empMapper.insertOne(emp);
    }

    @Override
    public void updateByName(String selectName, String newName) {
        Map<String, String> map = new HashMap<>();
        map.put("selectName", selectName);
        map.put("newName", newName);
        empMapper.updateByName(map);
    }

    @Override
    public void deleteById(int id) {
        empMapper.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        empMapper.deleteByName(name);
    }

    @Override
    public List<Emp> selectSelective(Emp emp) {
        return empMapper.selectSelective(emp);
    }

    @Override
    public void insertSelective(Emp emp) {
        empMapper.insertSelective(emp);
    }

    @Override
    public void updateSelective(Emp emp) {
        empMapper.updateSelective(emp);
    }

    @Override
    public void insertBatch(List<Emp> empList) {
        empMapper.insertBatch(empList);
    }

    @Override
    public void deleteBatch(List<Integer> empList) {
        empMapper.deleteBatch(empList);
    }

}
