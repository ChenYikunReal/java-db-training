package org.example;

import cn.pomit.mybatis.ProxyHandlerFactory;
import cn.pomit.mybatis.configuration.MybatisConfiguration;
import org.apache.ibatis.io.Resources;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.EmpExample;
import org.example.service.impl.DeptAndEmpMybatisExample;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DeptAndEmpExampleTest {

    @Test
    public void select1() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertEquals(0, management.select1().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void select2() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertEquals(1, management.select2().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void select3() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertNotEquals(0, management.select3().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update4() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertFalse(management.update4());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void select5() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertNotEquals(0, management.select5().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void select6() {
        try (InputStream in = Resources.getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            MybatisConfiguration.initConfiguration(properties);
            DeptAndEmpMybatisExample management = new DeptAndEmpMybatisExample();
            Assert.assertNotEquals(0, management.select6().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
