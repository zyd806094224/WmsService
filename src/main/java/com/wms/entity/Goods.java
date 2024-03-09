package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Goods {

    private int id;
    private String name;
    private int storage;
    @TableField("goodstype")
    private int goodsType;
    private int count;
    private String remark;
}
