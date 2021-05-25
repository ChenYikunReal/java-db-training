package org.example.service;

import org.example.pojo.Dept;

import java.util.List;

public interface DeptManagement {

    /**
     * 查询元组个数
     * @return
     */
    long countAll();

    /**
     * 依据name查询元组
     * @param name
     * @return
     */
    List<Dept> selectByName(String name);

    /**
     * 插入一个元组
     * @param dept
     */
    void insertOne(Dept dept);

    /**
     * 更新一个元组的name
     * @param selectName
     * @param newName
     */
    void updateByName(String selectName, String newName);

    /**
     * 依据name删除元组
     * @param name
     */
    void deleteByName(String name);

    /**
     * 模糊查询name
     * @param pattern
     * @return
     */
    List<Dept> selectFuzzyByName(String pattern);

    /**
     * 获取name有序的全部元组
     * @return
     */
    List<Dept> selectAllOrderByName();

}
