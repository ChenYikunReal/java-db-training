package com.example.controller;

import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyUserManagementControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSelectById() {
        String result = restTemplate.getForObject("/myuser/selectById?id=2", String.class);
        System.out.println(result);
    }

}
