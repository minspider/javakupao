package com.zyy.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    /**
     * 学号
     */
    private String sno;

    /**
     * 学生姓名
     */
    private String sname;

    /**
     * 学生年龄
     */
    private Byte sage;

    /**
     * 学生性别
     */
    private Object ssex;

    /**
     * 学生生日
     */
    private Date sbirthday;

    /**
     * 学生班级
     */
    private String classs;

    private static final long serialVersionUID = 1L;
}