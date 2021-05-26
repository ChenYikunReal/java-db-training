package com.example.service;

import com.example.pojo.Emp;

import java.util.List;

public interface EmpManagement {

    /**
     * 依据ID查询元组
     * @param id
     * @return
     */
    Emp selectById(int id);

    /**
     * 依据name查询元组
     * @param name
     * @return
     */
    List<Emp> selectByName(String name);

    /**
     * 插入一个元组
     * @param emp
     */
    void insertOne(Emp emp);

    /**
     * 更新一个元组的name
     * @param selectName
     * @param newName
     */
    void updateByName(String selectName, String newName);

    /**
     * 依据ID删除元组
     * @param id
     */
    void deleteById(int id);

    /**
     * 依据name删除元组
     * @param name
     */
    void deleteByName(String name);

    /**
     * 有选择地查询
     * @param emp
     * @return
     */
    List<Emp> selectSelective(Emp emp);

    /**
     * 有选择地插入
     * @param emp
     */
    void insertSelective(Emp emp);

    /**
     * 有选择地删除
     * @param emp
     */
    void updateSelective(Emp emp);

    /**
     * 批量插入
     * @param empList
     */
    void insertBatch(List<Emp> empList);

    /**
     * 批量删除
     * @param empList
     */
    void deleteBatch(List<Integer> empList);
    
}
