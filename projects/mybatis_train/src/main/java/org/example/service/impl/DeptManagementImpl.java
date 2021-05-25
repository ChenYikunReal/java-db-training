package org.example.service.impl;

import cn.pomit.mybatis.ProxyHandlerFactory;
import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.pojo.DeptExample;
import org.example.service.DeptManagement;

import java.util.List;

public class DeptManagementImpl implements DeptManagement {

    private final DeptMapper deptMapper = ProxyHandlerFactory.getMapper(DeptMapper.class);

    @Override
    public long countAll() {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria deptCriteria = deptExample.createCriteria();
        return deptMapper.countByExample(deptExample);
    }

    @Override
    public List<Dept> selectByName(String name) {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria deptCriteria = deptExample.createCriteria();
        deptCriteria.andDnameEqualTo(name);
        return deptMapper.selectByExample(deptExample);
    }

    @Override
    public void insertOne(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public void updateByName(String selectName, String newName) {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria deptCriteria = deptExample.createCriteria();
        deptCriteria.andDnameEqualTo(selectName);
        Dept dept = new Dept();
        dept.setDname(newName);
        deptMapper.updateByExampleSelective(dept, deptExample);
    }

    @Override
    public void deleteByName(String name) {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria deptCriteria = deptExample.createCriteria();
        deptCriteria.andDnameEqualTo(name);
        deptMapper.deleteByExample(deptExample);
    }

}
