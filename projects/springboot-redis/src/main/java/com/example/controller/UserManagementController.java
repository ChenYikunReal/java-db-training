package com.example.controller;

import com.example.pojo.User;
import com.example.repository.UserRepository;
import com.example.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserManagement redisService;

    @Autowired
    private UserRepository userRepository;

    // localhost:8888/user/saveUser?id=8&userName=HHH&userPassword=hhh
    @GetMapping(value = "/saveUser")
    public String saveUser(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        redisService.set(id.toString(), user);
        return "success";
    }

    // localhost:8888/user/getUserById?id=2
    @GetMapping(value = "/getUserById")
    public Object getUserById(Long id) {
        return redisService.get(id.toString());
    }

    // localhost:8888/user/getUser?id=2
    @GetMapping(value = "/getUser")
    public Object getUser(Long id) {
        Object object = redisService.get(id.toString());
        if (object == null) {
            object = (userRepository.findById(id)).orElse(null);
            if (object != null) {
                redisService.set(id.toString(), object, 100L, TimeUnit.SECONDS);
            }
        }
        return object;
    }

}
