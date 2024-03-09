package com.wms.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record {

    private int id;
    private int goods;
    private int userId;
    private int admin_id;
    private int count;
    private Date createtime;
    private String remark;
}
