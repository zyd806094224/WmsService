package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
//        return userService.listAll();
    }

    //新增
    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    //修改
    @PostMapping("/mod")
    public void mod(@RequestBody User user) {
        userService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public void saveOrMod(@RequestBody User user) {
        userService.saveOrUpdate(user);
    }

    //删除
    @GetMapping("/delete")
    public void delete(Integer id) {
        userService.removeById(id);
    }

    //模糊查询 匹配
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, user.getName());
        return userService.list(lambdaQueryWrapper);
    }
}
