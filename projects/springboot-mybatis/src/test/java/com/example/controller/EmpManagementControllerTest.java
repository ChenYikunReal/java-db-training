package com.example.controller;

import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 需要先启动服务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmpManagementControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSelectById() {
        String result = restTemplate.getForObject("/emp/selectById?id=7521", String.class);
        System.out.println(result);
    }

    @Test
    public void testSelectByName() {
        String result = restTemplate.getForObject("/emp/selectByName?name=BLAKE", String.class);
        System.out.println(result);
    }

    @Test
    public void testInsertOne() {
        String result = restTemplate.getForObject("/emp/insertOne", String.class);
        System.out.println(result);
    }

    @Test
    public void testUpdateByName() {
        String result = restTemplate.getForObject("/emp/updateByName?selectName=BILIBILI&newName=WAIBIBABO", String.class);
        System.out.println(result);
    }

    @Test
    public void testDeleteByName() {
        String result = restTemplate.getForObject("/emp/deleteByName?name=WAIBIBABO", String.class);
        System.out.println(result);
    }

    @Test
    public void testInsertOneAgain() {
        String result = restTemplate.getForObject("/emp/insertOne", String.class);
        System.out.println(result);
    }

    @Test
    public void testDeleteById() {
        String result = restTemplate.getForObject("/emp/deleteById?id=8000", String.class);
        System.out.println(result);
    }

    @Test
    public void testSelectSelective() {
        String result = restTemplate.getForObject("/emp/selectSelective", String.class);
        System.out.println(result);
    }

    @Test
    public void testInsertSelective() {
        String result = restTemplate.getForObject("/emp/insertSelective", String.class);
        System.out.println(result);
    }

    @Test
    public void testUpdateSelective() {
        String result = restTemplate.getForObject("/emp/updateSelective", String.class);
        System.out.println(result);
    }

    @Test
    public void testInsertBatch() {
        String result = restTemplate.getForObject("/emp/insertBatch", String.class);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatch() {
        String result = restTemplate.getForObject("/emp/deleteBatch", String.class);
        System.out.println(result);
    }

}
