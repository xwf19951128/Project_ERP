package com.cskaoyan.mapper.login;

import com.cskaoyan.bean.login.SysUser;
import com.cskaoyan.bean.user.Role;
import com.cskaoyan.bean.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 登录时所用的方法，查询用户名是否存在
     * */
    SysUser queryUserByUsername(@Param("username") String username);
    /**
     * 登录时所用的方法，查询用户名+密码是否正确
     * */
    SysUser queryUserByUsernameAndPassword(@Param("user") SysUser user);

    List<User> getUserList();

    List<Role> getRoleData();

    User queryUserById(String id);

    int insertUser(@Param("user") User user);

    void insertUserRole(@Param("user") User user, @Param("uuid") String uuid);

    int deleteBatchUser(@Param("ids") String[] ids);

    void deleteBatchRole(@Param("ids") String[] ids);

    void updateRole(@Param("user") User user);

    int updateUser(@Param("user") User user);

    List<User> searchUserByUserId(@Param("term") String term);

    List<User> searchUserByUserName(@Param("term")String term);

    List<User> searchUserByRoleName(@Param("term")String term);
}
