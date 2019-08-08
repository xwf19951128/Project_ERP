package com.cskaoyan.mapper.login;

import com.cskaoyan.bean.login.SysUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 登录时所用的方法，查询用户名是否存在
     * */
    public SysUser queryUserByUsername(@Param("username") String username);
    /**
     * 登录时所用的方法，查询用户名+密码是否正确
     * */
    public SysUser queryUserByUsernameAndPassword(@Param("user") SysUser user);
}
