package org.example.service.impl;

import cn.pomit.mybatis.ProxyHandlerFactory;
import org.example.mapper.SalGradeMapper;
import org.example.pojo.SalGrade;
import org.example.pojo.SalGradeExample;
import org.example.service.SalGradeManagement;

import java.util.List;

public class SalGradeManagementImpl implements SalGradeManagement {

    private final SalGradeMapper salGradeMapper = ProxyHandlerFactory.getMapper(SalGradeMapper.class);

    @Override
    public long countAll() {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        return salGradeMapper.countByExample(salGradeExample);
    }

    @Override
    public List<SalGrade> selectByGrade(int grade) {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        saleGradeCriteria.andGradeEqualTo(grade);
        return salGradeMapper.selectByExample(salGradeExample);
    }

    @Override
    public List<SalGrade> selectByLosalBetween(int low, int high) {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        saleGradeCriteria.andHisalBetween(low, high);
        return salGradeMapper.selectByExample(salGradeExample);
    }

    @Override
    public void insertOne(SalGrade salGrade) {
        salGradeMapper.insert(salGrade);
    }

    @Override
    public void updateByGrade(int selectGrade, SalGrade newSalGrade) {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        saleGradeCriteria.andGradeEqualTo(selectGrade);
        salGradeMapper.updateByExampleSelective(newSalGrade, salGradeExample);
    }

    @Override
    public void deleteByGrade(int grade) {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        saleGradeCriteria.andGradeEqualTo(grade);
        salGradeMapper.deleteByExample(salGradeExample);
    }

    @Override
    public List<SalGrade> selectAllOrderByHisal() {
        SalGradeExample salGradeExample = new SalGradeExample();
        SalGradeExample.Criteria saleGradeCriteria = salGradeExample.createCriteria();
        salGradeExample.setOrderByClause("hisal DESC");
        return salGradeMapper.selectByExample(salGradeExample);
    }

}
