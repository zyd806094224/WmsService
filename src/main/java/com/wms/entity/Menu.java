package com.wms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Menu {

    private int id;
    @TableField("menucode")
    private String menuCode;
    @TableField("menuname")
    private String menuName;
    @TableField("menulevel")
    private String menuLevel;
    @TableField("menuparentcode")
    private String menuParentCode;
    @TableField("menuclick")
    private String menuClick;
    @TableField("menuright")
    private String menuRight;
    @TableField("menucomponent")
    private String menuComponent;
    @TableField("menuicon")
    private String menuIcon;
}
