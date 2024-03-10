package com.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Goods {

    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private int storage;
    @TableField("goodstype")
    private int goodsType;
    private int count;
    private String remark;
}
