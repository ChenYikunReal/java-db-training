package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.StudentInfo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisInsertTest {

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
            int stu_num1 = session.selectOne("org.example.entity.StudentInfo.get_student_count");
            // 插入数据
            session.insert("org.example.entity.StudentInfo.add_student", student);
            // 插入后用户数量
            int stu_num2 = session.selectOne("org.example.entity.StudentInfo.get_student_count");
            // 提交事务
            session.commit();
            // 关闭Session
            session.close();
            // 判断前后是否差1
            Assert.assertEquals(stu_num1+1, stu_num2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
