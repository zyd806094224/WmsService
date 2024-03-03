package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goodsType")
public class GoodsType {

    private int id;
    private String name;
    private String remark;
}
