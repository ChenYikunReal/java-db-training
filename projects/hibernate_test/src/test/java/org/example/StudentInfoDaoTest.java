package org.example;

import org.example.entity.StudentInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class StudentInfoDaoTest {

    @Test
    public void curdTest() {
        // 创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 得到一个Session
        Session session = sessionFactory.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 创建对象
        StudentInfo student = new StudentInfo(15, "Kaisa", 3, "2018-7-7", "kaisa@163.com", "America");
        // 将创建的对象保存到表中
        session.save(student);
        // 修改对象
        student.setName("海洋哥");
        // 将更新的对象保存到表中
        session.update(student);
        // 查询数据
        StudentInfo queryStudent = session.get(StudentInfo.class, 1);
        Assert.assertNotNull(queryStudent);
        // 删除数据
        session.delete(student);
        // 自动刷新缓存
        session.flush();
        // 提交事务
        transaction.commit();
        // Session关闭
        session.close();
        // SessionFactory关闭
        sessionFactory.close();
    }

}
