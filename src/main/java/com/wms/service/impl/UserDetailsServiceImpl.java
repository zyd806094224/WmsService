package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wms.entity.LoginUser;
import com.wms.entity.RolePermissions;
import com.wms.entity.User;
import com.wms.mapper.RolePermissionsMapper;
import com.wms.mapper.UserMapper;
import com.wms.service.RolePermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    @Autowired
    private RolePermissionsService rolePermissionsService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getNo,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        LambdaQueryWrapper<RolePermissions> rpQueryWrapper = new LambdaQueryWrapper<>();
        rpQueryWrapper.eq(RolePermissions::getRoleId,user.getRoleId());
        RolePermissions rolePermissions = rolePermissionsMapper.selectOne(rpQueryWrapper);
        String[] split = rolePermissions.getPermissions().split(",");
        List<String> list = Arrays.asList(split);
//        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        //把数据封装成UserDetails返回
        return new LoginUser(user,list);
    }
}
