package com.cskaoyan.service.login;

import com.cskaoyan.bean.login.SysUser;
import com.cskaoyan.bean.user.Role;
import com.cskaoyan.bean.user.User;

import java.util.List;

public interface UserService {

     SysUser queryUserByUsername(String username);

     SysUser queryUserByUsernameAndPassword(SysUser user);

    List<User> getUserList();

    List<Role> getRoleData();

    User queryUserById(User user);

    int insertUser(User user);

    int deleteBatch(String[] ids);

    int updateAll(User user);

    List<User> searchUserByUserId(String term);

    List<User> searchUserByUserName(String term);

    List<User> searchUserByRoleName(String term);
}
