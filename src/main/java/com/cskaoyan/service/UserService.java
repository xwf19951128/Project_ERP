package com.cskaoyan.service;

import com.cskaoyan.bean.SysUser;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    public SysUser queryUserByUsername(String username);

    public SysUser queryUserByUsernameAndPassword(SysUser user);
}
