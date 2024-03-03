package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.Menu;
import com.wms.entity.User;
import com.wms.service.MenuService;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
//        return userService.listAll();
    }

    //id查找
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        return list.size() > 0 ? Result.success(list) : Result.fail();
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user) ? Result.success() : Result.fail();
    }

    //更新
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.updateById(user) ? Result.success() : Result.fail();
    }

    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return userService.removeById(id) ? Result.success() : Result.fail();
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        List<User> list = userService.lambdaQuery()
                .eq(User::getNo, user.getNo())
                .eq(User::getPassword, user.getPassword()).list();
        if (list.size() > 0) {
            User user1 = list.get(0);
            List<Menu> menuList = menuService.lambdaQuery().like(Menu::getMenuRight, user1.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user", user1);
            res.put("menu", menuList);
            return Result.success(res);
        }
        return Result.fail();
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
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getName())) {
            lambdaQueryWrapper.like(User::getName, user.getName());
        }
        return Result.success(userService.list(lambdaQueryWrapper));
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
    public Result listPageC(@RequestBody QueryPageParam param) {
        Page<User> page = new Page();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());

        IPage<User> result = userService.pageC(page);
        return Result.success(result.getRecords(), result.getTotal());
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
        String sex = "";
        try {
            sex = (String) param.getParam().get("sex");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String roleId = "";
        try {
            roleId = (String) param.getParam().get("roleId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }
        if (StringUtils.isNotBlank(sex)) {
            lambdaQueryWrapper.eq(User::getSex, sex);
        }
        if (StringUtils.isNotBlank(roleId)) {
            lambdaQueryWrapper.eq(User::getRoleId, roleId);
        }
        IPage<User> result = userService.pageCC(page, lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
}
