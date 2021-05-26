package com.example.web;

import com.example.pojo.Emp;
import com.example.service.EmpManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpManagementController {

    @Autowired
    private EmpManagement empManagement;

    // localhost:8888/emp/selectById?id=7521
    @GetMapping("/selectById")
    public String selectById(int id) {
        return empManagement.selectById(id).toString();
    }

    // localhost:8888/emp/selectByName?name=BLAKE
    @GetMapping("/selectByName")
    public String selectByName(String name) {
        StringBuilder sb = new StringBuilder();
        List<Emp> empList = empManagement.selectByName(name);
        for (Emp emp : empList) {
            sb.append(emp.toString()).append('\n');
        }
        return sb.toString();
    }

    // localhost:8888/emp/insertOne
    @GetMapping("/insertOne")
    public String insertOne() {
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        Emp emp = new Emp(8000, "BILIBILI", "CLERK", 7782, date, 1300.00f, null, 10);
        empManagement.insertOne(emp);
        return "success!";
    }

    // localhost:8888/emp/updateByName?selectName=BILIBILI&newName=WAIBIBABO
    @GetMapping("/updateByName")
    public String updateByName(String selectName, String newName) {
        empManagement.updateByName(selectName, newName);
        return "success!";
    }

    // localhost:8888/emp/deleteById?id=8000
    @GetMapping("/deleteById")
    public String deleteById(int id) {
        empManagement.deleteById(id);
        return "success!";
    }

    // localhost:8888/emp/deleteByName?name=WAIBIBABO
    @GetMapping("/deleteByName")
    public String deleteByName(String name) {
        empManagement.deleteByName(name);
        return "success!";
    }

    // localhost:8888/emp/selectSelective
    @GetMapping("/selectSelective")
    public String selectSelective() {
        StringBuilder sb = new StringBuilder();
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("WARD");
        emp.setDeptno(30);
        List<Emp> empList = empManagement.selectSelective(emp);
        for (Emp e : empList) {
            sb.append(e.toString()).append('\n');
        }
        return sb.toString();
    }

    // localhost:8888/emp/insertSelective
    @GetMapping("/insertSelective")
    public String insertSelective() {
        Emp emp = new Emp();
        emp.setEmpno(8000);
        emp.setEname("FFFF");
        emp.setJob("CLERK");
        emp.setDeptno(10);
        empManagement.insertSelective(emp);
        return "success!";
    }

    // localhost:8888/emp/updateSelective
    @GetMapping("/updateSelective")
    public String updateSelective() {
        Emp emp = new Emp();
        emp.setEmpno(8000);
        emp.setEname("PPPP");
        emp.setDeptno(10);
        empManagement.updateSelective(emp);
        return "success!";
    }

    // localhost:8888/emp/insertBatch
    @GetMapping("/insertBatch")
    public String insertBatch() {
        List<Emp> empList = new ArrayList<>();
        Emp emp1 = new Emp();
        emp1.setEmpno(8000);
        emp1.setEname("PPPP");
        emp1.setDeptno(10);
        Emp emp2 = new Emp();
        emp2.setEmpno(9000);
        emp2.setEname("SSSS");
        emp2.setDeptno(10);
        empList.add(emp1);
        empList.add(emp2);
        empManagement.insertBatch(empList);
        return "success!";
    }

    // localhost:8888/emp/deleteBatch
    @GetMapping("/deleteBatch")
    public String deleteBatch() {
        List<Integer> empList = new ArrayList<>();
        empList.add(8000);
        empList.add(9000);
        empManagement.deleteBatch(empList);
        return "success!";
    }

}
