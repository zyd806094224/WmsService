package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
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

    //分页
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam param) {
        Page<User> page = new Page();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());

        IPage<User> result = userService.page(page);
        return result.getRecords();
    }

    //自定义分页
    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam param) {
        Page<User> page = new Page();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());

        IPage<User> result = userService.pageC(page);
        return result.getRecords();
    }

    //自定义分页2
    @PostMapping("/listPageCC")
    public List<User> listPageCC(@RequestBody QueryPageParam param) {
        Page<User> page = new Page();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());

        String name = "";
        try {
            name = (String) param.getParam().get("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage<User> result = userService.pageCC(page, lambdaQueryWrapper);
        return result.getRecords();
    }

    //返回封装数据类
    @PostMapping("/listPageCC2")
    public Result listPageCC2(@RequestBody QueryPageParam param) {
        Page<User> page = new Page();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());
        String name = "";
        try {
            name = (String) param.getParam().get("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);
        IPage<User> result = userService.pageCC(page, lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
}
