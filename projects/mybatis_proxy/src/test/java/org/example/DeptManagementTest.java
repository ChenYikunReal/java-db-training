package org.example;

import cn.pomit.mybatis.configuration.MybatisConfiguration;
import org.apache.ibatis.io.Resources;
import org.example.pojo.Dept;
import org.example.service.DeptManagement;
import org.example.service.impl.DeptManagementImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class DeptManagementTest {

    @Test
    public void testCountAll() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptManagement deptManagement = new DeptManagementImpl();
            Assert.assertNotEquals(0, deptManagement.countAll());
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
            DeptManagement deptManagement = new DeptManagementImpl();
            Dept dept = deptManagement.selectById(20);
            Assert.assertNotNull(dept);
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
            DeptManagement deptManagement = new DeptManagementImpl();
            List<Dept> deptList = deptManagement.selectByName("SALES");
            Assert.assertNotEquals(0, deptList.size());
            Assert.assertEquals(1, deptList.size());
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
            DeptManagement deptManagement = new DeptManagementImpl();
            Dept dept = new Dept();
            dept.setDeptno(50);
            dept.setDname("kv");
            dept.setLoc("kkkv");
            deptManagement.insertOne(dept);
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
            DeptManagement deptManagement = new DeptManagementImpl();
            deptManagement.updateByName("kv", "mm");
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
            DeptManagement deptManagement = new DeptManagementImpl();
            deptManagement.deleteById(50);
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
            DeptManagement deptManagement = new DeptManagementImpl();
            deptManagement.deleteByName("mm");
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
            DeptManagement deptManagement = new DeptManagementImpl();
            List<Dept> deptList = deptManagement.selectFuzzyByName("TI");
            Assert.assertEquals(2, deptList.size());
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
            DeptManagement deptManagement = new DeptManagementImpl();
            List<Dept> deptList = deptManagement.selectAllOrderByName();
            Assert.assertNotEquals(0, deptList.size());
            for (Dept dept : deptList) {
                System.out.println(dept);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
