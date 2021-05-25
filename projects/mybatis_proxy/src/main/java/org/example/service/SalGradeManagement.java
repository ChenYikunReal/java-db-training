package org.example.service;

import org.example.pojo.SalGrade;

import java.util.List;

public interface SalGradeManagement {

    /**
     * 查询元组个数
     * @return
     */
    long countAll();

    /**
     * 依据grade查询元组
     * @param grade
     * @return
     */
    List<SalGrade> selectByGrade(int grade);

    /**
     * 根据losal区间查询元组
     * @param low
     * @param high
     * @return
     */
    List<SalGrade> selectByLosalBetween(int low, int high);

    /**
     * 插入一个元组
     * @param salGrade
     */
    void insertOne(SalGrade salGrade);

    /**
     * 依据grade查找并更新一个元组
     * @param selectGrade
     * @param newSalGrade
     */
    void updateByGrade(int selectGrade, SalGrade newSalGrade);

    /**
     * 依据grade删除元组
     * @param grade
     */
    void deleteByGrade(int grade);

    /**
     * 获取hisal有序的全部元组
     * @return
     */
    List<SalGrade> selectAllOrderByHisal();
    
}
