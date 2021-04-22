package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        // 这里直接调用HibernateUtil工具类中的getSession()方法获得Session
        Session session = sessionFactory.openSession();
        String hql = "FROM StudentInfo";
        Query query = session.createQuery(hql);
        List results = query.list();
        for (Object obj : results) {
            System.out.println(obj);
        }
        session.close();
    }

}
