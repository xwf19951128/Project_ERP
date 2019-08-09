package com.cskaoyan.service.login;

import com.cskaoyan.bean.login.SysUser;

public interface UserService {

    public SysUser queryUserByUsername(String username);

    public SysUser queryUserByUsernameAndPassword(SysUser user);
}
