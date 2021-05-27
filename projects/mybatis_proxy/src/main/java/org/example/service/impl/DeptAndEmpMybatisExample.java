package org.example.service.impl;

import cn.pomit.mybatis.ProxyHandlerFactory;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Dept;
import org.example.pojo.DeptExample;
import org.example.pojo.Emp;
import org.example.pojo.EmpExample;

import java.util.ArrayList;
import java.util.List;

public class DeptAndEmpMybatisExample {

    private final DeptMapper deptMapper = ProxyHandlerFactory.getMapper(DeptMapper.class);

    private final EmpMapper empMapper = ProxyHandlerFactory.getMapper(EmpMapper.class);

    public List<Emp> select1() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andEnameEqualTo("SMITH").andSalGreaterThanOrEqualTo(3000.0f);
        return empMapper.selectByExample(empExample);
    }

    public List<Emp> select2() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        list.add(7783);
        list.add(7876);
        criteria.andEmpnoIn(list);
        return empMapper.selectByExample(empExample);
    }

    public List<Emp> select3() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andCommIsNotNull();
        return empMapper.selectByExample(empExample);
    }

    public boolean update4() {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        Emp emp = empMapper.selectByPrimaryKey(7783);
        if (emp == null) {
            return false;
        }
        emp.setSal(emp.getSal()+200);
        empMapper.updateByExampleSelective(emp, empExample);
        return true;
    }

    public List<Emp> select5() {
        EmpExample empExample = new EmpExample();
        empExample.or().andEmpnoEqualTo(10);
        empExample.or().andSalLessThan(2000.0f);
        return empMapper.selectByExample(empExample);
    }

    public List<Emp> select6() {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria deptCriteria = deptExample.createCriteria();
        deptCriteria.andDnameEqualTo("RESEARCH");
        List<Dept> deptList = deptMapper.selectByExample(deptExample);
        List<Emp> empList = new ArrayList<>();
        for (Dept dept : deptList) {
            EmpExample empExample = new EmpExample();
            EmpExample.Criteria empExampleCriteria = empExample.createCriteria();
            empExampleCriteria.andDeptnoEqualTo(dept.getDeptno());
            empList.addAll(empMapper.selectByExample(empExample));
        }
        return empList;
    }

}
