# WmsService
仓库管理系统

## 项目简介

这是一个基于Spring Boot的仓库管理系统，用于管理仓库中的物品、库存记录、用户信息等。系统提供了完整的增删改查功能，支持分页查询、条件筛选、用户权限管理等功能。

## 技术栈

- 后端框架：Spring Boot 2.7.6
- 安全框架：Spring Security + JWT
- 数据库：MySQL 8.0
- 持久层框架：MyBatis-Plus 3.4.1
- 缓存：Redis
- JSON处理：FastJSON
- API文档：Swagger
- 构建工具：Maven
- Java版本：Java 8

## 系统功能模块

### 1. 用户管理模块
- 用户登录认证（JWT Token）
- 用户信息的增删改查
- 用户分页查询与条件筛选
- 用户角色管理（管理员/普通用户）

### 2. 物品管理模块
- 物品信息的增删改查
- 物品分类管理
- 物品存储位置管理
- 物品库存数量管理

### 3. 仓库管理模块
- 仓库信息管理
- 仓库物品存储管理

### 4. 记录管理模块
- 物品出入库记录管理
- 记录查询与筛选
- 操作记录分页展示

## 数据库设计

系统主要包含以下数据表：

- `user`：用户表，存储用户基本信息和权限
- `goods`：物品表，存储物品信息、库存数量等
- `storage`：仓库表，存储仓库信息
- `goods_type`：物品种类表，存储物品种类信息
- `record`：记录表，存储物品出入库记录

## 核心特性

1. **权限控制**：基于Spring Security和JWT实现用户认证和权限控制，区分管理员和普通用户权限
2. **数据分页**：所有列表页面均支持分页查询和条件筛选
3. **操作记录**：完整记录物品的出入库操作，便于追溯
4. **库存管理**：实时更新物品库存数量，避免库存错误
5. **RESTful API**：提供标准的RESTful风格API接口

## 项目结构

```
src
├── main
│   ├── java/com/wms
│   │   ├── common       // 公共类（配置、返回结果封装等）
│   │   ├── controller   // 控制器层
│   │   ├── entity       // 实体类
│   │   ├── filter       // 过滤器
│   │   ├── handler      // 安全处理器
│   │   ├── mapper       // MyBatis Mapper接口
│   │   ├── service      // 服务层
│   │   └── utils        // 工具类
│   └── resources
│       ├── mapper       // MyBatis XML映射文件
│       └── application.yml // 配置文件
```

## 配置说明

在`application.yml`中配置数据库连接信息：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/wms?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: "000000dong"
```

## 快速开始

1. 克隆项目到本地
2. 创建MySQL数据库，执行数据库脚本
3. 修改`application.yml`中的数据库连接配置
4. 启动Redis服务
5. 运行项目：`mvn spring-boot:run`
6. 访问地址：http://localhost:8088

## API接口

系统提供以下主要API接口：

- 用户登录：`POST /user/login`
- 物品管理：`/goods/**`
- 仓库管理：`/storage/**`
- 记录管理：`/record/**`
- 用户管理：`/user/**`

## 安全机制

- 使用JWT进行用户身份验证
- 基于角色的访问控制（RBAC）
- Redis缓存用户登录信息
- 密码加密存储

## 开发工具

- 使用Lombok简化Java代码
- MyBatis-Plus简化数据库操作
- Swagger生成API文档（待完善）

## 后续优化方向

1. 完善前端页面展示
2. 添加更详细的日志记录
3. 实现更复杂的库存预警机制
4. 添加数据统计和报表功能