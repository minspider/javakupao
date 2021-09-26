package com.zyy.controller;

import com.zyy.dao.StudentDao;
import com.zyy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/")
    public Student test(){
        return studentDao.selectByPrimaryKey("1");
    }
    @GetMapping("/user/name")
    public Map<String,Object> user(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","wyg");
        map.put("pwd","Wyg19991205");
        return map;
    }


}
