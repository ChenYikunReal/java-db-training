package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.StudentInfo;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisDemo {

    public static void main(String[] args) {
        // 读取配置文件
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            // 初始化mybatis，创建SqlSessionFactory类实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 创建Session实例
            SqlSession session = sqlSessionFactory.openSession();
            StudentInfo student = new StudentInfo(15, "Kaisa", 3, "2018-7-7", "kaisa@163.com", "America");
            // 插入数据
            session.insert("org.example.entity.StudentInfo.add_student", student);
            // 提交事务
            session.commit();
            // 关闭Session
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
