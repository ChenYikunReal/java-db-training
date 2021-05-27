package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private int id;

    private String name;

    private List<MyUser> myusers;

}
