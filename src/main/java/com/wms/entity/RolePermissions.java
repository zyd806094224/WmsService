package com.wms.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("role_permissions")
@Data
public class RolePermissions {
    @TableField("role_id")
    private int roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("permissions")
    private String permissions;
}
