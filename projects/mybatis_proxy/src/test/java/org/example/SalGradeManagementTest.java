package org.example;

import cn.pomit.mybatis.configuration.MybatisConfiguration;
import org.apache.ibatis.io.Resources;
import org.example.pojo.SalGrade;
import org.example.service.SalGradeManagement;
import org.example.service.impl.SalGradeManagementImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class SalGradeManagementTest {

    @Test
    public void testCountAll() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            Assert.assertNotEquals(0, SalGradeManagement.countAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByGrade() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            List<SalGrade> SalGradeList = SalGradeManagement.selectByGrade(3);
            Assert.assertNotEquals(0, SalGradeList.size());
            Assert.assertEquals(1, SalGradeList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByLosalBetween() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            List<SalGrade> SalGradeList = SalGradeManagement.selectByLosalBetween(1300, 3010);
            Assert.assertNotEquals(0, SalGradeList.size());
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
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            SalGrade SalGrade = new SalGrade(6, 10000, 19999);
            SalGradeManagement.insertOne(SalGrade);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateByGrade() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            SalGrade salGrade = new SalGrade();
            salGrade.setHisal(29999);
            SalGradeManagement.updateByGrade(6, salGrade);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByGrade() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            SalGradeManagement.deleteByGrade(6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAllOrderByHisal() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            SalGradeManagement SalGradeManagement = new SalGradeManagementImpl();
            List<SalGrade> SalGradeList = SalGradeManagement.selectAllOrderByHisal();
            Assert.assertNotEquals(0, SalGradeList.size());
            for (SalGrade SalGrade : SalGradeList) {
                System.out.println(SalGrade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
