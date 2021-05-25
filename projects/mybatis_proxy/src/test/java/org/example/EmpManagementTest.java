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
            EmpManagement EmpManagement = new EmpManagementImpl();
            Assert.assertNotEquals(0, EmpManagement.countAll());
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            Emp Emp = EmpManagement.selectById(7521);
            Assert.assertNotNull(Emp);
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            List<Emp> EmpList = EmpManagement.selectByName("BLAKE");
            Assert.assertNotEquals(0, EmpList.size());
            Assert.assertEquals(1, EmpList.size());
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            Emp Emp = new Emp(8000, "BILIBILI", "CLERK", 7782, date, 1300.00f, null, 10);
            EmpManagement.insertOne(Emp);
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            EmpManagement.updateByName("BILIBILI", "WAIBIBABO");
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            EmpManagement.deleteById(8000);
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            EmpManagement.deleteByName("WAIBIBABO");
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            List<Emp> EmpList = EmpManagement.selectFuzzyByName("LA");
            Assert.assertEquals(2, EmpList.size());
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
            EmpManagement EmpManagement = new EmpManagementImpl();
            List<Emp> EmpList = EmpManagement.selectAllOrderByName();
            Assert.assertNotEquals(0, EmpList.size());
            for (Emp Emp : EmpList) {
                System.out.println(Emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
