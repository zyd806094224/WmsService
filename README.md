# WmsService
仓库管理系统


#以下创建用户表脚本
create table user
(
id       int auto_increment comment '主键'
primary key,
no       varchar(20)       null comment '账号',
name     varchar(100)      not null comment '名字',
password varchar(20)       not null comment '密码',
age      int               null,
sex      int               null comment '性别',
phone    varchar(20)       null comment '电话',
role_id  int               null comment '角色 0超级管理员，1管理员，2普通账号',
isValid  varchar(4) default 'Y' null comment '是否有效，Y有效，其他无效'
)
charset = utf8;
#以上创建用户表脚本

#以下创建菜单表脚本
create table menu
(
id int(11) not null,
menuCode varchar(8) default null comment '菜单编码',
menuName varchar(16) default null comment '菜单名字',
menuLevel varchar(2) default null comment '菜单级别',
menuParentCode varchar(8) default null comment '菜单的父code',
menuClick varchar(16) default null comment '点击触发的函数',
menuRight varchar(8) default null comment '权限 0超级管理员，1表示管理员，2表示普通用户，可以用逗号组合使用',
menuComponent varchar(200) default null comment '页面路径',
menuIcon varchar(100) default null,
primary key (id)
) ENGINE=InnoDB DEFAULT charset=utf8;

BEGIN;
INSERT INTO `menu` VALUES (1,'001','管理员管理','1',NULL,'Admin','0','admin/AdminMange.vue','el-icon-s-custom');
INSERT INTO `menu` VALUES (2,'002','用户管理','1',NULL,'User','0,1','user/UserMange.vue','el-icon-user-solid');
COMMIT;

#以上创建菜单表脚本
