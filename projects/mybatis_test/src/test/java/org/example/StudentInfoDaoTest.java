package org.example;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.StudentInfo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentInfoDaoTest {

    @Test
    public void insertTest() {
        // 读取配置文件
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            // 初始化mybatis，创建SqlSessionFactory类实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 创建Session实例
            SqlSession session = sqlSessionFactory.openSession();
            // 新建对象
            StudentInfo student = new StudentInfo(15, "Kaisa", 3, "2018-7-7", "kaisa@163.com", "America");
            // 初始用户数量
            int stu_num1 = session.selectOne("org.example.entity.StudentInfo.count_student");
            // 插入数据
            session.insert("org.example.entity.StudentInfo.add_student", student);
            // 插入后用户数量
            int stu_num2 = session.selectOne("org.example.entity.StudentInfo.count_student");
            // 更新前用户数据
            int stu_num3 = session.selectOne("org.example.entity.StudentInfo.count_student_name", "Kaisa");
            // 更新数据
            Map<String, String> updateParamMap = new HashMap<>();
            updateParamMap.put("select_name", "Kaisa");
            updateParamMap.put("new_name", "KevinVista");
            session.update("org.example.entity.StudentInfo.update_student_name", updateParamMap);
            // 更新前用户数据
            int stu_num4 = session.selectOne("org.example.entity.StudentInfo.count_student_name", "KevinVista");
            // 删除数据
            session.delete("org.example.entity.StudentInfo.delete_student_by_name", "KevinVista");
            // 删除后用户数据
            int stu_num5 = session.selectOne("org.example.entity.StudentInfo.count_student_name", "KevinVista");
            // 提交事务
            session.commit();
            // 关闭Session
            session.close();
            // 判断插入前后是否差1
            Assert.assertEquals(stu_num1+1, stu_num2);
            // 判断更新前后是否相同
            Assert.assertNotEquals(0, stu_num3);
            Assert.assertEquals(stu_num3, stu_num4);
            // 判断删除后是否为0
            Assert.assertEquals(0, stu_num5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
