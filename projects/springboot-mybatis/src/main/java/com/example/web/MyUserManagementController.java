package com.example.web;

import com.example.pojo.MyUser;
import com.example.service.MyUserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myuser")
public class MyUserManagementController {

    @Autowired
    private MyUserManagement myUserManagement;

    // localhost:8888/myuser/selectById?id=2
    @GetMapping("/selectById")
    public String selectById(int id) {
        StringBuilder sb = new StringBuilder();
        List<MyUser> empList = myUserManagement.selectById(id);
        for (MyUser user : empList) {
            sb.append("id=").append(user.getId()).append(", ").append("username=").append(user.getUsername()).
                    append(", ").append("password=").append(user.getPassword()).append(", ").append("role_id=").
                    append(user.getRole().getId()).append(", ").append("role_name=").
                    append(user.getRole().getName()).append('\n');
        }
        return sb.toString();
    }

}
