package com.cskaoyan.service.login;

import com.cskaoyan.bean.login.SysUser;
import com.cskaoyan.mapper.login.UserMapper;
import com.cskaoyan.service.login.UserService;
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
