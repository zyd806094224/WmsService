package com.wms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sms")
public class Sms implements Serializable {

    /*[
    {
        "phone_number" : "1381111****",
            "content" : "内容",
            "send_time" : "2017-09-01 00:00:00",
            "dest_code" : "1234",
            "sequence_id" : "1234567890"
    }
]*/


    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("phonenumber")
    private String phonenumber;

    private String content;

    @TableField("sendtime")
    private String sendtime;

    @TableField("destcode")
    private String destcode;

    @TableField("sequenceid")
    private String sequenceid;


}
