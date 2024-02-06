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
