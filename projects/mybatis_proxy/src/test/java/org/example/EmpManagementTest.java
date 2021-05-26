package org.example;

import cn.pomit.mybatis.configuration.MybatisConfiguration;
import org.apache.ibatis.io.Resources;
import org.example.pojo.Emp;
import org.example.service.EmpManagement;
import org.example.service.impl.EmpManagementImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmpManagementTest {

    @Test
    public void testCountAll() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            Assert.assertNotEquals(0, empManagement.countAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            Emp emp = empManagement.selectById(7521);
            Assert.assertNotNull(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByName() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            List<Emp> empList = empManagement.selectByName("BLAKE");
            Assert.assertNotEquals(0, empList.size());
            Assert.assertEquals(1, empList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertOne() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            Emp emp = new Emp(8000, "BILIBILI", "CLERK", 7782, date, 1300.00f, null, 10);
            empManagement.insertOne(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateByName() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            empManagement.updateByName("BILIBILI", "WAIBIBABO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteById() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            empManagement.deleteById(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByName() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            empManagement.deleteByName("WAIBIBABO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectFuzzyByName() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            List<Emp> empList = empManagement.selectFuzzyByName("LA");
            Assert.assertEquals(2, empList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectOrderByName() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            EmpManagement empManagement = new EmpManagementImpl();
            List<Emp> empList = empManagement.selectAllOrderByName();
            Assert.assertNotEquals(0, empList.size());
            for (Emp emp : empList) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
