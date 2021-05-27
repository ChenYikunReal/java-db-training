package com.example.web;

import com.example.pojo.MyUser;
import com.example.pojo.Role;
import com.example.service.RoleManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleManagementController {

    @Autowired
    private RoleManagement roleManagement;

    // localhost:8888/role/selectById?id=2
    @GetMapping("/selectById")
    public String selectById(int id) {
        StringBuilder sb = new StringBuilder();
        List<Role> empList = roleManagement.selectById(id);
        for (Role role : empList) {
            sb.append("id=").append(role.getId()).append(", ").append("name=").append(role.getName()).append(", ");
            List<MyUser> userList = role.getMyusers();
            sb.append("userList=[");
            for (MyUser user : userList) {
                sb.append(user.getId()).append(" ").append(user.getUsername()).append(", ");
            }
            sb.append(']').append('\n');
        }
        return sb.toString();
    }

}
