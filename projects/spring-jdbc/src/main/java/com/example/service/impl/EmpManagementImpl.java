package com.example.service.impl;

import com.example.pojo.Emp;
import com.example.service.EmpManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpManagementImpl implements EmpManagement {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Emp selectById(int id) {
        String sql = "select * from emp where empno=?";
        List<Emp> empList = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Emp.class));
        return empList.get(0);
    }

    @Override
    public List<Emp> selectByName(String name) {
        String sql = "select * from emp where ename=?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Emp.class));
    }

    @Override
    public void insertOne(Emp emp) {
        String sql = "insert into emp values (?,?,?,?,?,?,?,?) ";
        Object[] args = new Object[] {emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                emp.getSal(), emp.getComm(), emp.getDeptno()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void updateByName(String selectName, String newName) {
        String sql = "update emp set ename=? where ename=?";
        jdbcTemplate.update(sql, new Object[]{newName, selectName});
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from emp where empno=?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public void deleteByName(String name) {
        String sql = "delete from emp where ename=?";
        System.out.println(name);
        jdbcTemplate.update(sql, new Object[]{name});
    }

}
