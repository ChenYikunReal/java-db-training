package org.example.service;

import org.example.pojo.Dept;

import java.util.List;

public interface DeptManagement {

    long countAll();

    List<Dept> selectByName(String name);

    void insertOne(Dept dept);

    void updateByName(String selectName, String newName);

    void deleteByName(String name);

}
