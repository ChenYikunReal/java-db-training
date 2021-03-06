package org.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Dept;
import org.example.pojo.DeptExample;

@Mapper
public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    long countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int deleteByPrimaryKey(Integer deptno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int insertSelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    Dept selectByPrimaryKey(Integer deptno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbg.generated Tue May 25 11:16:30 CST 2021
     */
    int updateByPrimaryKey(Dept record);
}