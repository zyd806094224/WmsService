package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Record {

    private int id;
    private int goods;
    @TableField("userid")
    private int userId;
    private int admin_id;
    private int count;
    private Date createtime;
    private String remark;

    @TableField(exist = false)
    private String action; //字段自用 非数据库字段
}
