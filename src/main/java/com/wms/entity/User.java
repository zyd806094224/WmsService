package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String no;
    private String name;
    private String password;
    private int age;
    private int sex;
    private int roleId;
    private String phone;
    @TableField("isvalid")
    private String isValid;
}
