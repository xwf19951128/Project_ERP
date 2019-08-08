package com.cskaoyan.service;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public SysUser queryUserByUsername(String username) {
        SysUser sysUser = userMapper.queryUserByUsername(username);
        return sysUser;
    }

    @Override
    public SysUser queryUserByUsernameAndPassword(SysUser user) {
        SysUser sysUser = userMapper.queryUserByUsernameAndPassword(user);
        return sysUser;
    }
}
