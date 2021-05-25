package org.example.service.impl;

import cn.pomit.mybatis.ProxyHandlerFactory;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.EmpExample;
import org.example.service.EmpManagement;

import java.util.List;

public class EmpManagementImpl implements EmpManagement {

    private final EmpMapper empMapper = ProxyHandlerFactory.getMapper(EmpMapper.class);

    @Override
    public long countAll() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        return empMapper.countByExample(empExample);
    }

    @Override
    public Emp selectById(int id) {
        return empMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Emp> selectByName(String name) {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        empCriteria.andEnameEqualTo(name);
        return empMapper.selectByExample(empExample);
    }

    @Override
    public void insertOne(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void updateByName(String selectName, String newName) {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        empCriteria.andEnameEqualTo(selectName);
        Emp emp = new Emp();
        emp.setEname(newName);
        empMapper.updateByExampleSelective(emp, empExample);
    }

    @Override
    public void deleteById(int id) {
        empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByName(String name) {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        empCriteria.andEnameEqualTo(name);
        empMapper.deleteByExample(empExample);
    }

    @Override
    public List<Emp> selectFuzzyByName(String pattern) {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        empCriteria.andEnameLike("%" + pattern + "%");
        return empMapper.selectByExample(empExample);
    }

    @Override
    public List<Emp> selectAllOrderByName() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria empCriteria = empExample.createCriteria();
        empExample.setOrderByClause("ename ASC");
        return empMapper.selectByExample(empExample);
    }

}
